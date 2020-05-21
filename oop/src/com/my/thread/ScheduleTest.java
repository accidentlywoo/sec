package com.my.thread;

public class ScheduleTest {
	public static void main(String[] args) {
		Third one = new Third();
		for(int i = 1; i < 10; i++) {
			System.out.println((i+99)*1.0F);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		one.start();
		
		System.out.println("main()의 끝입니다.");
	}
}
