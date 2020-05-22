package com.my.thread;

public class B {
	Share s;
	
	public void run() {
		s.dec();
	}
}
