package com.my.thread;

public class B extends Thread{
	Share s;
	
	public void run() {
		System.out.println("===B Overriding : ");
		s.dec();
	}
}
