package com.my.thread;

class First extends Thread{
	public void run() {
		for(int i = 1; i <= 100; i++) {
			Thread currentThread = Thread.currentThread(); // run 상태의 객체 / 현재 Thread의 상태
			String currtName = currentThread.getName();
			System.out.println("currentThread Name : " + currtName+ " i = "+i);
			System.out.println("Instance Name : " + this.getName()); //현재 객체의 이름
		}
	}
}

public class Test {
	public static void a() {
		Thread currentThread = Thread.currentThread();
		String currtName = currentThread.getName();
		System.out.println("a currentThread Name : " + currtName);
	}
	
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String currtName = currentThread.getName();
		System.out.println("currentThread Name : " + currtName);
		/*
		 * Class.forName에서일어나는 일.
		 * 
		 * 1. 클래스 찾기
		 * 2. JVM에 로드
		 * 3. 바이트코드 검증
		 * 4. 인터프리트
		 * 5. static 자동 초기화
		 * 6. main-thread 자동생성 : 기본적으로 생성
		 *		7. main() 호출됨
		 */
		a();
		
		First one = new First();
//		one.run();// 새로운 스레드 시작이 아님. main Thread와 같은 name이 나온다,
		one.start(); // 새로운 Thread-0
//		one.start(); // java.lang.IllegalThreadStateException
		First one1 = new First();
		one1.start(); // 새로운 Thread-1
		
	}
}
