package com.my.thread;

public class ScheduleTest {
	public static void main(String[] args) {
//		Third one = new Third();
//		Fourth f = new Fourth();
//		Customer c = new Customer();
////		f.setName("첫번째");
////		one.setName("두번째");
//		c.setName("Customer");
//		one.start();
//		f.start();
//		c.start();
		Fifth one = new Fifth(1, 10);
		Fifth two = new Fifth(11,20);
		
		one.start();
		two.start();
		
		try {
			one.join(); // main Thread가 one Thread가 죽기를 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			two.join(); // main Thread가 one Thread가 죽기를 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(one.getTot()); // 결과값이 다르다!
		System.out.println(one.getTot());
		System.out.println(two.getTot());
		
		System.out.println("main()의 끝입니다.");
	}
}
