package com.my.view;

import java.util.Scanner;

import com.my.controll.CustomerController;

public class WelcomeView {
	private Scanner sc;
	
	private CustomerController customerController;
	
	public void customerView(WelcomeView view) {
		view.customerMenuView();
		int menu = Integer.parseInt(view.sc.nextLine());
		switch (menu) {
		case 1:
			view.loginView(view);
			break;
		case 4:
			view.searchName();
			break;
		case 5:
			view.searchAll();
			break;
		case 6:
			view.searchId();
			break;
		case 7:
			view.searchNo();
			break;
		default:
			break;
		}
	}
	private void searchName() {
		customerController.login();
	}
	private void searchNo() {
		customerController.searchNo();
	}
	private void searchId() {
		customerController.searchId();
	}
	private void searchAll() {
		customerController.searchAll();
	}
	private void loginView(WelcomeView view) {
		// TODO Auto-generated method stub
		
	}
	public void customerMenuView() {
		System.out.println("Customer 화면 : "
				+ "1. 로그인" // , 2. 내정보 변경, 3. 회원 탈퇴하기
				+ "4. 회원 전체 검색, 5. 이름으로 회원 검색"
				+ "6. 아이디로 회원 검색, 7. 회원 번호로 회원 검색");
		System.out.println("작업을 번호로 선택하세요. : ex) 1");
	}
	public void mainMenuView() {
		System.out.println("Home 화면 : 1. 회원 정보보기, 2. 상품 정보보기, 3. 상품 구매하기");
		System.out.println("작업을 번호로 선택하세요. : ex) 1");
	}
	public void mainView(WelcomeView view) {
		view.mainMenuView();
		int menu = Integer.parseInt(view.sc.nextLine());
		switch (menu) {
		case 1:
			view.customerView(view);
			break;
		case 2:
			//TODO
//			view.productView();
			break;
		case 3:
			//TODO
//			view.orderView();
			break;
		default:
			break;
		}
	}
	public static void main(String[] args) {
		WelcomeView view = new WelcomeView();
		view.mainView(view);
	}
}
