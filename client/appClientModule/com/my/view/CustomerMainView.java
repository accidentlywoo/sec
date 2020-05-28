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
	private String serverIp = "192.168.0.118";
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
		System.out.println("--가입하기--");
		System.out.print("아이디:");
		String id = sc.nextLine(); //sc.next();
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("주소:");
		String addr = sc.nextLine();
		try {
			dio.send(new Customer(id, pwd, name, addr));
			String receiveStatus = dio.receive();
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
		System.out.println("--이름으로 검색하기--");
		System.out.print("이름에 포함될 단어:");
//		String word = sc.nextLine();
		//control.findByNameControl(word);
		System.out.println("TODO");
	}
	
	public void findAllView() {
		System.out.println("--전체고객 검색하기--");
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
		System.out.println("--ID로 검색하기--");
		System.out.print("아이디:");
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
		System.out.println("--로그인 하기--");
		System.out.print("아이디:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();
		try {
			dio.send(id);
			dio.send(pwd);
			String receiveStatus = dio.receiveStatus();
			String receiveMsg = dio.receive();
			if(receiveStatus.equals("success")) {
				//CustomerShare.loginedCustomer = dio.receiveCustomer(); //로그인된 고객객체를 공유
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
		System.out.println("--내정보 보기--");		
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
			System.out.println("--내정보 수정하기[수정안하려면 enter를 누르세요]--");
			System.out.print("비밀번호:");		
			String pwd = sc.nextLine();
			System.out.println("입력한 비번="  + pwd);
			System.out.print("이름(" + loginedCustomer.getName() +"):");
			String name = sc.nextLine();
			System.out.print("주소(" + loginedCustomer.getAddr() +"):");
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
		System.out.println("--탈퇴--");
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
		System.out.println("작업구분:1-가입, 2-전체고객 검색, 3-ID로 검색, 4-로그인, 9-종료");
	}
	public void loginedMainMenuView() {
		System.out.println("작업구분:1-내정보 보기, 2-내정보 수정하기, 3-탈퇴, 4-로그아웃, 9-종료");
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
				//if(CustomerShare.loginedCustomer == null) { //로그인성공안된상태
					mainView.mainMenuView();
					System.out.print("작업을 선택하세요:");
					menu = Integer.parseInt(mainView.getSc().nextLine());
					mainView.getDio().send(CustomerShare.loginedId);
					mainView.getDio().send(menu);
					
					switch(menu) {
					case 1://가입
						mainView.addView();
						break;
					case 2://전체검색
						mainView.findAllView();
						break;
					case 3://ID로 검색
						mainView.findByIdView();
						break;
					case 4://로그인
						mainView.loginView();
						break;
					case 9://종료
						break;
					}		
				}else { //로그인성공된  상태
					mainView.loginedMainMenuView(); 
					//--[id값]님--
					//1-내정보 보기, 2-내정보 수정하기, 3-탈퇴, 4-로그아웃, 9-종료
					System.out.print("작업을 선택하세요:");
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