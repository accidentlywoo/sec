package com.my.view;

public class SuccessView {
	
	private static SuccessView successView = new SuccessView();
	
	public static SuccessView getInstance() {
		return successView;
	}
	
	public void addCustomerView(Object message) {
		System.out.println(message + "성공"+"\n");
	}

}
