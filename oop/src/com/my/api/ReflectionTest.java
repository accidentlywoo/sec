package com.my.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionTest {
	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
		Scanner sc = new Scanner(System.in);
		System.out.println("클래스 이름은 입력하세요.[ex:java.util.Date]");
		String className = sc.next(); // complete tocken 까지만 값만 사용한다.
		try {
			Class clazz = Class.forName(className);
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				System.out.println("필드이름 : "+ field.getName()+" , 자료형 : "+field.getType());
				// Public field뿐만 아니라 private field도 추출할 수 있다.
			}
			
			Object o = clazz.newInstance(); // 오버라이뒹
//			System.out.println(o.toString());
			Method[] methods = clazz.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println("메소드이름 : "+method.getName());
				if(method.getName().equals("toString") ) {
					Object obj = method.invoke(o, null);
					System.out.println(obj);
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
