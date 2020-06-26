package step1;

import java.util.Scanner;

public class OverloadTest {
/*
 * 		Overload 조건
 * 		1. 메서드 이름 동일
 * 		2. 매개변수 타입 또는 개수 또는 순서가 다0름
 */
	public static void add(int a, int b) {System.out.println(a+b);}
	public static void add(float a, float b) {System.out.println(a+b);}
	public static void add(int a, int b, float c) {System.out.println(a+b+c);}
	public static void add(float a, int b, int c) {System.out.println(a+b+c);}
	
	//public static void add(int c, int d) {System.out.println(c+d);} 메서드 중복 - 변수명 상관없음
	//public int void add(int c, int d) {System.out.println(c+d);} 메서드 중복 - return type 상관없음
	
	public static void main(String[] args) {
		byte b1, b2;
		b1 = 10;
		b2 = 20;
		add(b1, b2); // int 타입으로 자동 형변환
		
		char c1, c2;
		c1 = 'A';
		c2 = 'B';
		add(c1, c2); // int 타입으로 자동 형변환
		
		long lo1, lo2;
		lo1 = 1L;
		lo2 = 2L;
		add(lo1, lo2); // float 타입은 Long 타입보다 크기가 크다.

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		if(N % 2 == 1){
			System.out.println("Weird");
		}
		else{
			if(N <= 5)
				System.out.println("Weird");
			else if( N <= 20)
				System.out.println("Weird");
			else
				System.out.println("Not Weird");
		}
		scanner.close();
	}
}
