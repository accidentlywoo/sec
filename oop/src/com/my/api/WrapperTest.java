package com.my.api;

import java.util.Date;

public class WrapperTest {
	public static void main(String[] args) {
		/* 기본자료형 : boolean, byte < short < int < long 
		 * 											char < int < long
		 * 									float < double
		 * 참조자료형 : 클래스타입, 인터페이스타입, 배열, 이넘
		 */
		Object object;
		object = new Object();
		object = new String("test");
		object = new com.my.vo.Customer();
		// 컴파일러가 하는 자동 박싱
		object = 1; // Auto Boxing : 자동 기본형을 참조형으로 변환하는 코드
		object = new Integer(1); // == object = 1;
		
		object = 'A';
		object = new Character('A');
		
		object = 3.5;
		object = new Double(3.5);
		
		object = true;
		object = new Boolean(true);
		
		// Wrapper Class 를 사용할 때의 장점
		// 1. primitive type은 어떠한 메소드를 갖지 못한다. toString() X
		System.out.println(new Integer(1).toString());
		//2. 유용한 필드 정보를 제공한다. 
		System.out.println(Integer.MAX_VALUE);
		
		// 컴파일러가 하는 언박싱
		object = 1;
		int i;
		i = (int) object; // 오토 언박싱
		
		// 오토 언박싱의 과정 
		Integer inte = (Integer)object;
		i = inte.intValue();
		
		// 오토 언박싱의 안좋은 예
		object = null;
//		i = (int)object; // NullPointException 발생
		
		if(object != null) {
			i = (int)object;
		}
		
		// Down Casting 에서 위험한 자료 묶음 처리 : ;ClassCastException 이발생한다.
		
		Object[] arr = new Object[5];
		arr[0] = new String("test");
		arr[1] = new Date();
		arr[2] = new Integer(3); // Boxing
		arr[3] = 4; // new Integer(4); 변환 AutoBoxing
		arr[4] = false;
		
		String s = (String)arr[0];
		Date d = (Date)arr[1];
		Integer int2 = (Integer)arr[2];
		int int3 = (int)arr[3];
		boolean b = (boolean)arr[4];
		
		// Date dr = (Date)arr[1]; 컴파일 성공 But ClassCastException 발생한다. 
		// 체크가 어려운 문제점이 발생 -> 제네릭을 사용해서 자료를 안전하게 묶어서 사용한다.
	}
}
