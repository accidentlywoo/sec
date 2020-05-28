package com.my.control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.io.DataIO;
import com.my.vo.Customer;
class FrontThread extends Thread{
	private Socket s;
	private DataIO dio;
	private CustomerControl control = CustomerControl.getInstance();
	private String loginedId;
	public FrontThread(Socket s) throws IOException {
		this.s = s;
		dio = new DataIO(new DataOutputStream(s.getOutputStream())
				,new DataInputStream(s.getInputStream()));
	}
	public void run() {
		int menu = 9;
		try {
			do {
				loginedId = dio.receive();
				menu = dio.receiveInt();
				if(loginedId.equals("")) {
					
//				if(CustomerShare.loginedCustomer == null) {
					System.out.println("�α��� �ȵ�  ���� server menu=" + menu);
					
					switch(menu) {
					case 1:
						addFront();
						break;
					case 2:
						findAllFront();
						break;
					case 3:
						findByIdFront();
						break;
					case 4:
						loginFront();
						break;
					case 9://����
						break;
					}		
				}else { //�α��μ�����  ����	
					System.out.println("�α��ε� ���� server menu=" + menu);
					switch(menu) {
					case 1://����������
						infoFront();
						break;
					case 2://����
						modifyFront();
						break;
					case 3://Ż��
						removeFront();
						break;
					case 4://�α׾ƿ�
						logoutFront();
						break;
					case 9://����
						break;
					}	
				}
			}while(menu != 9);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			dio.close();
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addFront() throws IOException {
		try {
			Customer c = dio.receiveCustomer();
			control.addControl(c);
			dio.sendSuccess("���Լ���");
		} catch (AddException e) {
			e.printStackTrace();
			dio.sendFail("���Խ���:" + e.getMessage());
		} 
	}
	public void findAllFront() throws IOException{
		try {
			List<Customer> list = control.findAllControl();
			dio.sendSuccess();
			dio.send(list.size());
			dio.send(list);
		} catch (FindException e) {
			e.printStackTrace();
			dio.sendFail("��ü�˻� ����:" + e.getMessage());
		}
	}
	public void findByIdFront() throws IOException {
		try {
			Customer c  = control.findByIdControl(dio.receive());
			dio.sendSuccess();
			dio.send(c);
			//success.findByIdCustomerView(c);
		} catch (FindException e) {
			e.printStackTrace();
			dio.sendFail("ID�� �˻� ����:" + e.getMessage());
			//fail.findByIdCustomerView("ID�� �˻� ����:" + e.getMessage());
		}
	}
	public void loginFront() throws IOException{
		try {
			String id = dio.receive();
			String pwd = dio.receive();
			control.loginControl(id, pwd);
			dio.sendSuccess("�α��� ����");
			//dio.send(com.my.share.CustomerShare.loginedCustomer);
			dio.send(id);
			System.out.println("�α��� ����: loginedCustomer="+com.my.share.CustomerShare.loginedCustomer);
			//success.loginCustomerView("�α��� ����");

		} catch (FindException e) {
			e.printStackTrace();
			dio.sendFail("�α��� ����");
			//fail.loginCustomerView("�α��� ����");
		}
	}
	public void infoFront() throws IOException {
		try {
			//Customer c = control.infoControl(CustomerShare.loginedCustomer.getId());
			Customer c = control.infoControl(loginedId);
			dio.sendSuccess();
			dio.send(c);
			//success.findByIdCustomerView(c);
		} catch (FindException e) {
			e.printStackTrace();
			dio.sendFail("���������� ����:" + e.getMessage());
			//fail.findByIdCustomerView("ID�� �˻� ����:" + e.getMessage());
		}
	}
	public void modifyFront() throws IOException{
		
		try {
			infoFront();
			control.modifyControl(dio.receiveCustomer());
			dio.sendSuccess("���� ����");
			//success.modifyCustomerView("���� ����");
		} catch (ModifyException e) {
			e.printStackTrace();
			dio.sendFail("��������:" + e.getMessage());
			//fail.modifyCustomerView("���� ����");
		}
	}
	public void removeFront() throws IOException{
		try{
			control.removeControl(loginedId);
			dio.sendSuccess("Ż�� ����");
			//		success.modifyCustomerView("Ż�� ����");
		} catch (RemoveException e) {
			e.printStackTrace();
			dio.sendFail("Ż�� ����:" + e.getMessage());
			//		fail.modifyCustomerView("Ż�� ����");
		}
	}
	public void logoutFront() throws IOException{
		//control.logoutControl();
		loginedId = "";
	}
}
public class Front {
	public static void main(String[] args) {
		int port = 2345;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
			while(true) {
				Socket s;
				s = ss.accept();
				new FrontThread(s).start();
			}
		}catch(Exception e) {

		}finally {
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
