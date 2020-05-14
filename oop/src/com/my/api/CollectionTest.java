package com.my.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	public static void test(Collection c) {
		c.add(new String("1"));
		c.add(new Integer(2));
		c.add(new Float(3.4F));
		c.add(4); // 컴파일 시점에서 c.add(new Integer(4)); 로 바뀜
		c.add(new Integer(2));
		
		System.out.println("저장된 요소의 개수 : "+c.size());
		
		//c.get() 없는 메소드
		Iterator iter = c.iterator(); //요소 조회
		while(iter.hasNext()) {
			Object e = iter.next();
			System.out.println(e);
		}
		c.remove(new Integer(2)); // 요소 삭제 List 인터페이스 구현체는 index 순서로 삭제
		System.out.println(c);
	}
	public static void main(String[] args) {
		Collection c;
		c = new ArrayList();
		test(c);
	}
}
