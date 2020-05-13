package com.my.api;

import java.util.Scanner;
class DCL{
	public static void test(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class claszz = Class.forName(className);
		claszz.newInstance(); // 매개변수없는 생성
		// 자바빈즈의 조건에 만족해야 런타임 다이나믹 로드를 할 수 있다.
		// -> public 매개변수없는 생성자
	}
}
public class DynamicClassLoad {
	
	public static void main(String[] args) {
		System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		String className = sc.next();
		try {
			DCL.test(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
