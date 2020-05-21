package com.my.thread;

class First extends Thread{
	public void run() {
		for(int i = 1; i <= 100; i++) {
			Thread currentThread = Thread.currentThread(); // run 상태의 객체 / 현재 Thread의 상태
			String currtName = currentThread.getName();
			System.out.println("currentThread Name : " + currtName+ " i = "+i);
			System.out.println("Instance Name : " + this.getName()); //현재 객체의 이름
		}
	}
}