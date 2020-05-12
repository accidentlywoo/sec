package com.my.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void test(int i) {
		int j = 10;
		System.out.println(j/i);
		// ArithmeticException, InputMismatchException
		
	}

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요. : ");
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			test(i);
		}catch (InputMismatchException e) {
			System.out.println(e);
		} catch (Exception e) {
			
		}
	}
}
