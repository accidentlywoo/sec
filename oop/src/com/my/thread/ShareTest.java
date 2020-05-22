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
//		a.run();
		a.start();
		System.out.println("===Main after a.run() : "+s.i);
//		b.run();
		b.start();
		System.out.println("===Main after b.run() : " + s.i);
		try {
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===Main join b.run() : " + s.i);
	}
}
