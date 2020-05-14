
package com.my.api;

import java.util.ArrayList;
import java.util.Collection;

public class GenericTest {
	public static void main(String[] args) {
		Collection<String> c;
		c = new ArrayList<String>(); // 버전 11 : new ArrayList();
		c.add("hello");
//		c.add(new Date()); 사용불가
		// 제네릭을 사용함으로써 
		// item의 타입을 알 수 있기 때문에, 반복문에서 효과적인 활용을 할 수 있다.
		for(String s : c) {
			
		} 
	}
}
