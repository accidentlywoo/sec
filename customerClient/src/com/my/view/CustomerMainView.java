package com.my.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.my.share.CustomerShare;
import com.my.vo.Customer;

public class CustomerMainView {
	private final int port = 1234;
	private final String serverIp = "192.168.0.115";
	private Socket socket;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	private Scanner sc;
	
	private SuccessView successView;
	private FailView failView;
	
	private String receive() throws IOException{
		return this.bufferedReader.readLine();
	}
	
	public CustomerMainView() {
		this.sc = new Scanner(System.in);
		successView = SuccessView.getInstance();
		failView = FailView.getInstance();
		try {
			this.socket = new Socket(serverIp, port);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Scanner getSc() {
		return sc;
	}
	private void resultView(String resultMsg) {
		try {
//			String result = bufferedReader.readLine();
			String result;
			result = bufferedReader.readLine();
			if(result.equals("성공")) {
				successView.addCustomerView(resultMsg);
			}else {
				failView.addCustimerView(resultMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addView() {
		System.out.println("----- 가입하기 입력-------");
		Customer customer = new Customer();
		try {
			System.out.print("아이디 : ");
			String id = getSc().nextLine();
			bufferedWriter.write("login:"+id+":");
			bufferedWriter.flush();
			customer.setId(id);
			System.out.print("비밀번호 : ");
			String pwd = getSc().nextLine();
			bufferedWriter.write(pwd+":");
			bufferedWriter.flush();
			customer.setPwd(pwd);
			System.out.print("이름 : ");
			String name = getSc().nextLine();
			bufferedWriter.write(name+":");
			bufferedWriter.flush();
			customer.setName(name);
			System.out.print("주소 : ");
			String addr = getSc().nextLine();
			bufferedWriter.write(addr+":");
			bufferedWriter.flush();
			customer.setAddr(addr);
			bufferedWriter.write(customer.toString()+"\r\n");
			bufferedWriter.flush();
			String receive;
			while((receive = receive()) != null) {
				System.out.println(receive);
				if(receive.equals("가입성공")) {
					break;
				}
			}
//			this.mainMenuView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findAllView() {
		try {
			bufferedWriter.write("findAll\n\r");
			bufferedWriter.flush();
			String receive;
			while((receive= receive())!= null) {
				System.out.println(receive);
				if(receive.equals("전체조회성공")) {
					break;
				}
			}
		} catch (NullPointerException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findByIdView() {
		System.out.print("찾을 아이디 입력 : ");
		try {
			bufferedWriter.write("mainmenu3");
			String id = getSc().nextLine()+":\n";
			bufferedWriter.write(id);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void infoView() {
		String id = CustomerShare.loginedCustomer.getId();
	}
	public void removeView() {
	}
	
	public void modifyView() {
		Customer costomer = CustomerShare.loginedCustomer;
		System.out.println("기존정보 " + costomer);
		Customer result = new Customer();
		result = costomer;
		System.out.println("비밀번호를 수정하겠습니까? [ 네 : '1' 입력 / 아니요 : '2' 입력 ]");
		try {
			int idi = Integer.parseInt(getSc().nextLine());
			if(idi == 1) {
				System.out.println("수정할 비밀번호를 입력하세요. : ");
				String pwd2 = getSc().nextLine();
				result.setPwd(pwd2);
			}
		} catch (NumberFormatException e) {
			System.out.println(" 잘못 입력하셨습니다. '1' 또는 '2' 를 입력하세요.");
		}
		System.out.println("이름를 수정하겠습니까? [ 네 : '1' 입력 / 아니요 : '2' 입력 ]");
		try {
			int ni = Integer.parseInt(getSc().nextLine());
			if(ni == 1) {
				System.out.println("수정할 이름를 입력하세요. : ");
				String name2 = getSc().nextLine();
				result.setName(name2);
			}
		} catch (NumberFormatException e) {
			System.out.println(" 잘못 입력하셨습니다. '1' 또는 '2' 를 입력하세요.");
		}
		System.out.println("주소를 수정하겠습니까? [ 네 : '1' 입력 / 아니요 : '2' 입력 ]");
		try {
			int adi = Integer.parseInt(getSc().nextLine());
			if(adi == 1) {
				System.out.println("수정할 주소를 입력하세요. : ");
				String add2 = getSc().nextLine();
				result.setAddr(add2);
			}
		} catch (NumberFormatException e) {
			System.out.println(" 잘못 입력하셨습니다. '1' 또는 '2' 를 입력하세요.");
		}
		
//		try {
//			control.modifyControll(result);
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void loginView() {
		System.out.print("아이디 입력 : ");
		String id = getSc().nextLine();
		System.out.println("패스워드 입력 : ");
		String pwd = getSc().nextLine();
		
	}
	
	public void logoutView() {
		CustomerShare.loginedCustomer = null;
	}
	

	public void mainMenuView() {
		System.out.println(
				"작업 구분 : 1.- 가입, 2.- 전체 고객 검색, 3.- ID로 검색, 4.-로그인, 9.- 종료");
		System.out.print("작업을 선택하세요 : ");
	}
	public void loginMenuView() {
		System.out.println(
				"작업 구분 : 1.- 내정보 보기, 2.- 내 정보 수정하기, 3.- 탈퇴하기, 4.-로그아웃하기, 5.- 메인화면으로 돌아가기, 9.- 종료");
		System.out.print("작업을 선택하세요 : ");
	}
	public void mainView(CustomerMainView mainView) {
		mainView.mainMenuView();
		int menu = Integer.parseInt(mainView.getSc().nextLine());
		switch (menu) {
		case 1: // 가입
			mainView.addView();
			break;
		case 2: // 전체 고객 검색
			mainView.findAllView();
			break;
		case 3: // ID로 검색
			mainView.findByIdView();
			break;
		case 4: // 로그인
			mainView.loginView();
			break;
		case 9: // 종료
			break;	
		default:
			System.out.println("잘못된 선택을 하셨습니다.");
			break;
		}
	}
	public void loginView(CustomerMainView mainView) {
		mainView.loginMenuView();
		int menu = Integer.parseInt(mainView.getSc().nextLine());
		switch (menu) {
		case 1: // 내 정보보기
			mainView.infoView();
			break;
		case 2: //수정하기
			mainView.infoView();
			mainView.modifyView();
			break;
		case 3: //  탈퇴하기
			System.out.println("탈퇴하기");
			mainView.removeView();
			break;
		case 4: // 로그아웃
			System.out.println("로그아웃하기");
			break;
		case 5: // 메인화면으로 돌아가기
			System.out.println("메인화면으로 돌아가기");
			CustomerShare.loginedCustomer = null;
			mainView.mainView(mainView);
			break;
		case 9: // 종료
			break;	
		default:
			System.out.println("잘못된 선택을 하셨습니다.");
			break;
		}
	}
	public static void main(String[] args) {
		CustomerMainView mainView = new CustomerMainView();
		while(true) { // loof excape?
			if(CustomerShare.loginedCustomer == null) {
				mainView.mainView(mainView);
			}else {
				mainView.loginView(mainView);
			}
		}
	}
}
