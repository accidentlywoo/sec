package com.my.thread;

import java.util.Date;

import com.my.vo.Customer;

public class Second extends Customer implements Runnable{

	private static final long serialVersionUID = 1L;

	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			System.out.println("현재시각 : "+ new Date());
		}
	}
}
