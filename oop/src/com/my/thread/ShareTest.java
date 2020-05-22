package com.my.thread;

public class ShareTest {
	public static void main(String[] args) {
		Share s = new Share();
		A a = new A();
		a.s = s;
		
		System.out.println(s==a.s);
		
		B b = new B();
		b.s = s;
		
		System.out.println(s.i);
		System.out.println(a.s.i);
		a.run();
		System.out.println("after a.run() : "+s.i);
		b.run();
		System.out.println("after b.run() : " + s.i);
	}
}
