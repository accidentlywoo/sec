package com.my.thread;

public class Test {
	public static void a() {
		Thread currentThread = Thread.currentThread();
		String currtName = currentThread.getName();
		System.out.println("a currentThread Name : " + currtName);
	}
	
	public static void main(String[] args) {
		int i = 1;
		try {
			if(i == 1) throw new NullPointerException();
			System.out.println("try");
		}finally {
			System.out.println("finally");
		}
		System.out.println("end");
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
		Second s = new Second();
		First one = new First();
		First one1 = new First();
		Thread two = new Thread(s);
//		one.run();// 새로운 스레드 시작이 아님. main Thread와 같은 name이 나온다,
		two.start();
		one.start(); // 새로운 Thread-0
//		one.start(); // java.lang.IllegalThreadStateException
		one1.start(); // 새로운 Thread-1
//		s.run();
		two.start();
	}
}
