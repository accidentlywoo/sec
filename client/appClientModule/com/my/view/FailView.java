package com.my.view;
public class FailView {
	private static FailView fail = new FailView();
	private FailView() {}
	public  static FailView getInstance() {
		return fail;
	}
	public void addCustomerView(String message) {
		System.out.println(message);		
	}
	public void findAllCustomerView(String message) {
		System.out.println(message);		
	}
	public void findByIdCustomerView(String message) {
		System.out.println(message);
	}
	public void loginCustomerView(String message) {
		System.out.println(message);
		
	}
	public void modifyCustomerView(String message) {
		System.out.println(message);
		
	}
	
}
