package com.my.view;

public class FailView {

	private static final FailView failView = new FailView();
	
	public static FailView getInstance() {
		return failView;
	}
	
	public void addCustimerView(String message) {
		System.out.println(message+"실패"+"\n");
	}

}
