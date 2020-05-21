package com.my.thread;

public class Fourth extends Thread{

	@Override
	public void run() {
		Thread cur = Thread.currentThread();
		String curName = cur.getName();
		for(int i = 0; i < 10; i++) {
			System.out.println(curName+"  : "+getName()+i);
			this.yield();
		}
	}
}
