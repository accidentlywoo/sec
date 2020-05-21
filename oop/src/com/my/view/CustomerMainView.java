package com.my.view;

import java.util.Scanner;

import com.my.control.CustomerControl;
import com.my.exception.FindException;
import com.my.share.CustomerShare;
import com.my.vo.Customer;

public class CustomerMainView {
	private Scanner sc;
	
	private CustomerControl control;

	public CustomerMainView() {
		this.sc = new Scanner(System.in);
		this.control = CustomerControl.getInstance();
		//this.control = new CustomerControl();
	}
	public Scanner getSc() {
		return sc;
	}
	
	public void addView() {
		System.out.println("----- 가입하기 입력-------");
		System.out.print("아이디 : ");
		String id = getSc().nextLine();
		System.out.print("비밀번호 : ");
		String pwd = getSc().nextLine();
		System.out.print("이름 : ");
		String name = getSc().nextLine();
		System.out.print("주소 : ");
		String addr = getSc().nextLine();
		
		// 데이터 저장 logic
		try {
			control.addControl(new Customer(id, pwd, name, addr));
		} catch (FindException e) {
			e.printStackTrace();
		}
		
	}
	
	public void findAllView() {
		control.findAllControl();
	}
	
	public void findByIdView() {
		System.out.print("찾을 아이디 입력 : ");
		String id = getSc().nextLine();
		control.findByIdControll(id);
	}
	public void infoView() {
		String id = CustomerShare.loginedCustomer.getId();
		control.findByIdControll(id);
	}
	public void removeView() {
		try {
			control.remove(CustomerShare.loginedCustomer);
		} catch (FindException e) {
			e.printStackTrace();
		}
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
		
		try {
			control.modifyControll(result);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loginView() {
		System.out.print("아이디 입력 : ");
		String id = getSc().nextLine();
		System.out.println("패스워드 입력 : ");
		String pwd = getSc().nextLine();
		control.loginControl(id, pwd);
		
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
