package com.my.thread;

public class Share {
	int i;
	public void inc() {
		for(int i = 1; i <= 100; i++) {
			System.out.println("before inc() this.i : " + this.i);
			this.i = this.i +1;
			System.out.println("after inc() this.i = "+this.i);
		}
	}
	
	public void dec() {
		for(int i = 1; i <= 100; i++) {
			System.out.println("before dec() this.i : " + this.i);
			this.i = this.i -1;
			System.out.println("after dec() this.i = "+this.i);
		}
	}
}
