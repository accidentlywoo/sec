package com.my.thread;

public class Sixth extends Thread{
	boolean flag;
	@Override
	public void run() {
		while(flag) {
			System.out.println("sixth");
		}
	}
}
