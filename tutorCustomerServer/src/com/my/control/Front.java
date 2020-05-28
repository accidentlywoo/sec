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
					System.out.println("로그인 안된  상태 server menu=" + menu);
					
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
					case 9://종료
						break;
					}		
				}else { //로그인성공된  상태	
					System.out.println("로그인된 상태 server menu=" + menu);
					switch(menu) {
					case 1://내정보보기
						infoFront();
						break;
					case 2://수정
						modifyFront();
						break;
					case 3://탈퇴
						removeFront();
						break;
					case 4://로그아웃
						logoutFront();
						break;
					case 9://종료
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
			dio.sendSuccess("가입성공");
		} catch (AddException e) {
			e.printStackTrace();
			dio.sendFail("가입실패:" + e.getMessage());
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
			dio.sendFail("전체검색 실패:" + e.getMessage());
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
			dio.sendFail("ID로 검색 실패:" + e.getMessage());
			//fail.findByIdCustomerView("ID로 검색 실패:" + e.getMessage());
		}
	}
	public void loginFront() throws IOException{
		try {
			String id = dio.receive();
			String pwd = dio.receive();
			control.loginControl(id, pwd);
			dio.sendSuccess("로그인 성공");
			//dio.send(com.my.share.CustomerShare.loginedCustomer);
			dio.send(id);
			System.out.println("로그인 성공: loginedCustomer="+com.my.share.CustomerShare.loginedCustomer);
			//success.loginCustomerView("로그인 성공");

		} catch (FindException e) {
			e.printStackTrace();
			dio.sendFail("로그인 실패");
			//fail.loginCustomerView("로그인 실패");
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
			dio.sendFail("내정보보기 실패:" + e.getMessage());
			//fail.findByIdCustomerView("ID로 검색 실패:" + e.getMessage());
		}
	}
	public void modifyFront() throws IOException{
		
		try {
			infoFront();
			control.modifyControl(dio.receiveCustomer());
			dio.sendSuccess("수정 성공");
			//success.modifyCustomerView("수정 성공");
		} catch (ModifyException e) {
			e.printStackTrace();
			dio.sendFail("수정실패:" + e.getMessage());
			//fail.modifyCustomerView("수정 실패");
		}
	}
	public void removeFront() throws IOException{
		try{
			control.removeControl(loginedId);
			dio.sendSuccess("탈퇴 성공");
			//		success.modifyCustomerView("탈퇴 성공");
		} catch (RemoveException e) {
			e.printStackTrace();
			dio.sendFail("탈퇴 실패:" + e.getMessage());
			//		fail.modifyCustomerView("탈퇴 실패");
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
