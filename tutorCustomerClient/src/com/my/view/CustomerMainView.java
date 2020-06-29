package com.my.view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import com.my.io.DataIO;
import com.my.share.CustomerShare;
import com.my.vo.Customer;

public class CustomerMainView {
	private Scanner sc;
	private SuccessView successView = SuccessView.getInstance();
	private FailView failView = FailView.getInstance();
	
	private int port = 2345;
	private String serverIp = "192.168.0.107";
	private Socket s;
	private DataIO dio;
	public CustomerMainView() throws UnknownHostException, IOException {
		sc = new Scanner(System.in);
		s = new Socket(serverIp, port);
		dio = new DataIO(new DataOutputStream(s.getOutputStream())
				       , new DataInputStream(s.getInputStream()));
	}
	
	public DataIO getDio() {
		return dio;
	}

	public void setDio(DataIO dio) {
		this.dio = dio;
	}

	public void addView() {
		System.out.println("--�����ϱ�--");
		System.out.print("���̵�:");
		String id = sc.nextLine(); //sc.next();
		System.out.print("��й�ȣ:");
		String pwd = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ּ�:");
		String addr = sc.nextLine();
		try {
			dio.send(new Customer(id, pwd, name, addr));
			String receiveStatus = dio.receiveStatus(); // 메소드 이름을 의미 있는 이름으로 사용한다.
			if(receiveStatus.equals("success")) {
				successView.addCustomerView(dio.receive());
			}else {
				failView.addCustomerView(dio.receive());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void findByNameView() {
		System.out.println("--�̸����� �˻��ϱ�--");
		System.out.print("�̸��� ���Ե� �ܾ�:");
//		String word = sc.nextLine();
		//control.findByNameControl(word);
		System.out.println("TODO");
	}
	
	public void findAllView() {
		System.out.println("--��ü�� �˻��ϱ�--");
		//control.findAllControl();
		try {
			String receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {
				int size = dio.receiveInt();
				List<Customer> list = dio.receiveCustomers(size);
				successView.findAllCustomerView(list);
			}else {
				String receiveMsg = dio.receive();
				failView.findAllCustomerView(receiveMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findByIdView() {
		System.out.println("--ID�� �˻��ϱ�--");
		System.out.print("���̵�:");
		String id = sc.nextLine();
		//control.findByIdControl(id);
		try {
			dio.send(id);
			String receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {
				Customer c = dio.receiveCustomer();
				successView.findByIdCustomerView(c);
			}else {
				String receiveMsg = dio.receive();
				failView.findByIdCustomerView(receiveMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void loginView() {
		System.out.println("--�α��� �ϱ�--");
		System.out.print("���̵�:");
		String id = sc.nextLine();
		System.out.print("��й�ȣ:");
		String pwd = sc.nextLine();
		try {
			dio.send(id);
			dio.send(pwd);
			String receiveStatus = dio.receiveStatus();
			String receiveMsg = dio.receive();
			if(receiveStatus.equals("success")) {
				//CustomerShare.loginedCustomer = dio.receiveCustomer(); //�α��ε� ����ü�� ����
				CustomerShare.loginedId = dio.receive();
				successView.loginCustomerView(receiveMsg);
			}else {
				failView.loginCustomerView(receiveMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void infoView() {
		System.out.println("--������ ����--");		
		try {
			String receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {				
				Customer loginedCustomer = dio.receiveCustomer();	
				successView.findByIdCustomerView(loginedCustomer);
			}else {
				failView.findByIdCustomerView(dio.receive());
				
			}
		} catch (IOException e) {
			e.printStackTrace();			
		}		
	}	

	public void modifyView() {
		Customer loginedCustomer = null;
		try {
			String receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {				
				loginedCustomer = dio.receiveCustomer();	
				successView.findByIdCustomerView(loginedCustomer);
			}else {
				failView.findByIdCustomerView(dio.receive());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			
			return;
		}
		try {
			System.out.println("--������ �����ϱ�[�������Ϸ��� enter�� ��������]--");
			System.out.print("��й�ȣ:");		
			String pwd = sc.nextLine();
			System.out.println("�Է��� ���="  + pwd);
			System.out.print("�̸�(" + loginedCustomer.getName() +"):");
			String name = sc.nextLine();
			System.out.print("�ּ�(" + loginedCustomer.getAddr() +"):");
			String addr = sc.nextLine();
			
			Customer c = new Customer();
			c.setId(loginedCustomer.getId());
			c.setPwd(pwd);
			c.setName(name);
			c.setAddr(addr);
			//control.modifyControl(c);
		
			dio.send(c);
			String receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {
				String receiveMsg = dio.receive();
				successView.modifyCustomerView(receiveMsg);
			}else {
				String receiveMsg = dio.receive();
				failView.modifyCustomerView(receiveMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
	public void removeView() {
		System.out.println("--Ż��--");
		//control.removeControl();
		String receiveStatus;
		try {
			receiveStatus = dio.receiveStatus();
			if(receiveStatus.equals("success")) {
				String receiveMsg = dio.receive();
				successView.modifyCustomerView(receiveMsg);
			}else {
				String receiveMsg = dio.receive();
				failView.modifyCustomerView(receiveMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		logoutView();
	}
	public void logoutView() {
		CustomerShare.loginedId = "";
	}
	
	public void mainMenuView() {
		System.out.println("�۾�����:1-����, 2-��ü�� �˻�, 3-ID�� �˻�, 4-�α���, 9-����");
	}
	public void loginedMainMenuView() {
		System.out.println("�۾�����:1-������ ����, 2-������ �����ϱ�, 3-Ż��, 4-�α׾ƿ�, 9-����");
	}
	public void closeView() {
		dio.close();
	}
	public Scanner getSc() {
		return sc;
	}
	public static void main(String []args) {
		CustomerMainView mainView = null;
		try {
			mainView = new CustomerMainView();
			int menu = 9;
			do {
				System.out.println("in client menu=" + menu);
				if("".equals(CustomerShare.loginedId)) {
				//if(CustomerShare.loginedCustomer == null) { //�α��μ����ȵȻ���
					mainView.mainMenuView();
					System.out.print("�۾��� �����ϼ���:");
					menu = Integer.parseInt(mainView.getSc().nextLine());
					mainView.getDio().send(CustomerShare.loginedId);
					mainView.getDio().send(menu);
					
					switch(menu) {
					case 1://����
						mainView.addView();
						break;
					case 2://��ü�˻�
						mainView.findAllView();
						break;
					case 3://ID�� �˻�
						mainView.findByIdView();
						break;
					case 4://�α���
						mainView.loginView();
						break;
					case 9://����
						break;
					}		
				}else { //�α��μ�����  ����
					mainView.loginedMainMenuView(); 
					//--[id��]��--
					//1-������ ����, 2-������ �����ϱ�, 3-Ż��, 4-�α׾ƿ�, 9-����
					System.out.print("�۾��� �����ϼ���:");
					menu = Integer.parseInt(mainView.getSc().nextLine());
					mainView.getDio().send(CustomerShare.loginedId);
					mainView.getDio().send(menu);
					switch(menu) {
					case 1:
						mainView.infoView();
						break;
					case 2:
						mainView.modifyView();
						break;
					case 3:
						mainView.removeView();
						break;
					case 4:
						mainView.logoutView(); 				
						break;
					case 9:
						break;
					}
				}
			}while(menu != 9);
		}catch(UnknownHostException e) {
			
		}catch(IOException e) {
			
		}finally {
			if(mainView != null)
				mainView.closeView();
		}
	}
}