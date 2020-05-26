package com.my.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.service.CustomerService;
import com.my.vo.Customer;

public class CustomerControl extends Thread {

	private CustomerService customerService;
	private Socket socket;
	private ObjectOutputStream objectOutputStream; // write
	private ObjectInputStream objectInputStream; // read
	private List<CustomerControl> controls;
	private String clientAddress;
	
	private <T> T getClazz() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		String clazz = objectInputStream.readObject().getClass().getName();
		Class<?> cls = Class.forName(clazz);
		Object obj = cls.newInstance();
		T dataClass = (T)obj;
		return dataClass;
	}
	public CustomerControl(Socket socket) throws IOException {
		this(socket, null);
		this.customerService = new CustomerService();
	}
	public CustomerControl(Socket socket, List<CustomerControl> controls) throws IOException {
		this.customerService = new CustomerService();
		this.socket = socket;
		this.controls = controls;
		this.clientAddress = this.socket.getInetAddress().getHostName();
		this.objectInputStream = new ObjectInputStream(socket.getInputStream());
		this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	}
	
	private String receive(){
		String result=null;
		try {
			result= (String)this.objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	private void broadSendMessage(String sendMsg) {
		try {
			this.objectOutputStream.writeObject(sendMsg + "\n");
			this.objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void broadConnectMessage(String sendMsg) {
		for(CustomerControl item : controls) {
			item.broadSendMessage(sendMsg);
		}
		
	}
	
	public void findAllControl() {
		try {
			List<Customer> result = customerService.findAll();
		} catch (FindException e) {
		}
	}
	public void findByIdControll(String id) {
		try {
			Customer result = customerService.findById(id);
		} catch (FindException e) {
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
		Object receive; // 뒤에 "\n" 꼭 붙
		try {
			getClazz();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
