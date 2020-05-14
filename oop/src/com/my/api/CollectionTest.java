package com.my.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionTest {
	public static void test(Collection c) {
		c.add(new String("1"));
		c.add(new Integer(2));
		c.add(new Float(3.4F));
		c.add(4); // 컴파일 시점에서 c.add(new Integer(4)); 로 바뀜
		c.add(new Integer(2));
		
		System.out.println("저장된 요소의 개수 : "+c.size());
		
		for(Object item : c) {
			System.out.println(item);
		}
		
		c.remove(new Integer(2)); // 요소 삭제 List 인터페이스 구현체는 index 순서로 삭제
		System.out.println(c);
	}
	private static void test(HashMap m) {
		m.put(new Integer(1), "first");
		m.put(new Integer("2"), "second");
		m.put(3, "third");
		m.put(2, "fourth");
		System.out.println("저장된 요소의 개수 : "+m.size());
		System.out.println("------- 요소 조회하기 --------");
		Set s = m.keySet(); // 전체 키값 반환
		/*Iterator iter = s.iterator();
		while(iter.hasNext()) {
			Object k = iter.next();
			Object v = m.get(k);
			System.out.println(k + " = "+ v);
		}*/
		for(Object i : s) {
			Object v = m.get(i);
			System.out.println("key 값 : "+i + ", value 값 : "+ v);
		}
		m.remove(3);
		System.out.println(m);
	}
	public static void main(String[] args) {
		Collection c;
		c = new ArrayList();
		test(c);
		test(new HashSet());
		test(new HashMap());
	}
}
