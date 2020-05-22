package com.my.thread;

public class A extends Thread{
	Share s;
	
	public void run() {
		System.out.println("===A Overriding : ");
		s.inc();
	}
}
