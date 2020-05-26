package com.my.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.service.CustomerService;
import com.my.vo.Customer;

public class CustomerBufferedControl extends Thread {

	private CustomerService customerService;
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private List<CustomerBufferedControl> controls;
	private String clientAddress;
	
	public CustomerBufferedControl(Socket socket) throws IOException {
		this(socket, null);
		this.customerService = new CustomerService();
	}
	public CustomerBufferedControl(Socket socket, List<CustomerBufferedControl> controls) throws IOException {
		this.customerService = new CustomerService();
		this.socket = socket;
		this.controls = controls;
		this.clientAddress = this.socket.getInetAddress().getHostName();
		this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	private String receive() throws IOException{
		return this.bufferedReader.readLine();
	}
	private void broadSendMessage(String sendMsg) {
		try {
			this.bufferedWriter.write(sendMsg + "\n");
			this.bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void broadConnectMessage(String sendMsg) {
		for(CustomerBufferedControl item : controls) {
			item.broadSendMessage(sendMsg);
		}
		
	}
	
	public void loginControl(String id, String pwd) {
		try {
			Customer result = customerService.findById(id);
		} catch (FindException e) {
		}
	}
	public void modifyControll(Customer customer) throws FindException {
		try {
			customerService.modify(customer);
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}
	public void remove(Customer customer) throws FindException {
		try {
			customerService.remove(customer);
		} catch (RemoveException e) {
		}
	}
	@Override
	public void run() {
		String sendMsg = "접속 IP : " + clientAddress;
		broadConnectMessage(sendMsg);
		String receive; // 뒤에 "\n" 꼭 붙
		try {
			while((receive = receive()) != null) {
				if(receive.equals("9")) break;
				
				if(receive.split(":")[0].equals("mainmenu1")) {
					bufferedReader.readLine();
					Customer customer = new Customer();
					customerService.add(customer);
				}else if(receive.split(":")[0].equals("mainmenu2")) {
					List<Customer> result = customerService.findAll();
					for(Customer item : result) {
						bufferedWriter.write(item.toString());
					}
				}if(receive.split(":")[0].equals("mainmenu3")) {
					Customer result = customerService.findById(receive.split(":")[1]);
					bufferedWriter.write(result.toString());
				}if(receive.equals("mainmenu4")) { // login
					
				}else {
					bufferedWriter.write("실패");
				}
			}
		} catch (NullPointerException e) {
		} catch (SocketException e) {
			System.out.println("Socket에 문제가 생겼습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AddException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sendMsg = clientAddress + "가 접속 해제했습니다.";
			broadSendMessage(sendMsg);
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferedReader!=null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferedWriter!=null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
