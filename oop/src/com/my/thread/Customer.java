package com.my.thread;

public class Customer extends Thread{
	private String name;
	
	@Override	public void run() {
		Thread cur = Thread.currentThread();
		String curName = cur.getName();
		for(int i = 0; i < 10; i++) {
			System.out.println(curName+" !!!  : "+getName()+i);
			this.yield();
		}
	}
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
