package com.my.thread;

public class ScheduleTest {
	public static void main(String[] args) {
		Sixth one = new Sixth();
		one.flag = true;
		one.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		one.flag = false;
		System.out.println("main()의 끝입니다.");
	}
}
