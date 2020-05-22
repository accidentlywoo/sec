package com.my.thread;

public class A {
	Share s;
	
	public void run() {
		s.inc();
	}
}
