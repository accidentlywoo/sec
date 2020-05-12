package com.my.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void test(int i) {
		int j = 10;
//		if(i == 0) {
//			System.out.println("분모는 0이 될 수 없습니다.");
//			return;
//		}
		try {
			System.out.println(j/i);
			// ArithmeticException, InputMismatchException
		} catch (ArithmeticException e) {
			System.out.println(e + "0으로 나눌 수 없습니다.");
		}
	}
	public static void io() {
		FileInputStream filInputStream = null; // flow check
		String fileName = "a.txt";
		String notFoundFile = "b.txt";
		// cmd에서 java 명령어로 접근한 경로에서 시작
		try {
			filInputStream = new FileInputStream(notFoundFile); // a.txt 자원과 연결
			int readValue = filInputStream.read();
			System.out.println("readFile : "+readValue);
//		}catch (IOException e || FileNotFoundException e) {   상속 관계의 Exception을 | 연산으로 나란히 둘 수 없다.
		}catch (IOException e) { // 몰아서 예외처리하기
			e.printStackTrace();
			System.out.println("getMessage : "+e.getMessage());
		}
//		} catch (FileNotFoundException e) { //예외처리를 상세하게 할때는 자식관계를 먼저 비교해야 논리적 표현을 할 수 있다.
//			e.printStackTrace(); // 사용자에게 보여주지 말자. 디버깅용으로 쓰자
//		}catch (IOException e) {
//			// TODO: handle exception
//		}
		finally {
			if(filInputStream != null) { // try를 안할 수 있으면 안하는게 성능에 좋다.
				try {
					filInputStream.close(); // 자원과 연결해제
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static int[] arr = new int[5];
	private static int cnt = 0;
	public static void insertArr(int value) {
		try {
			arr[cnt] = value;
			cnt++;	
			// arr[cnt++] = value; 단항 연산자 쓰면 뺨맞는다. catch에서 6출력
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("저장소가 꽉 찼습니다. 현재 배열의 크기 ( cnt )="+cnt);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요. : ");
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			test(i);
		}catch (InputMismatchException e) {
			System.out.println(e+"정수를 입력하세요. ");
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			// 예외 관계없이 처리할 내용 
			sc.close();
		}
		io();
		insertArr(9);
		insertArr(-1);
		insertArr(3);
		insertArr(7);
		insertArr(-3);
		insertArr(99);
	}
}
