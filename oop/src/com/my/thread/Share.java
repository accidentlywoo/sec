package com.my.thread;

public class Share {
	int i;
	public void inc() {
		for(int i = 1; i <= 100; i++) {
			this.i = this.i +1;
		}
	}
	
	public void dec() {
		for(int i = 1; i <= 100; i++) {
			this.i = this.i -1;
		}
	}
}
