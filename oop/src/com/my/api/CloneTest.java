package com.my.api;

import java.util.Arrays;

class A implements Cloneable{
	int i = 1;
	int[] arr = {1, 2, 3};
	public A shallowCopy() {
		try {
			Object object = this.clone();
			return (A)object;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public A deepCopy() {
		try {
			Object object = this.clone(); // shallow copy
			int[] arr = (int[])this.arr.clone(); // reference type의 객체를 계속 shallow로 타야하나?
			A a = (A) object;
			a.arr = arr;
			return a;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}

public class CloneTest {
	public static void main(String[] args) {
		 // 네트워크 프로그래밍에서 객체 복제작업을 통해 클라이언트에게 지속적인 정보를 제공할때 사용한다.
		A a1 = new A();
		//a1.clone(); The method clone() from the type Object is not visible
		A a2 = a1.shallowCopy();
		
		A a3 = a1.deepCopy();
		
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		
		System.out.println("a1.i : "+ a1.i + "a1.arr : "+ Arrays.toString(a1.arr));
		System.out.println("a2.i : " + a2.i + "a2.arr : "+ Arrays.toString(a2.arr));
		System.out.println("a3.i : " + a3.i + "a3.arr : "+ Arrays.toString(a3.arr));
		
		System.out.println("----------- shallo copy ------------");
		a1.i = 9; a1.arr[0] = 99;
		System.out.println("a1.i : "+ a1.i + "a1.arr : "+ Arrays.toString(a1.arr));
		System.out.println("a2.i : " + a2.i + "a2.arr : "+ Arrays.toString(a2.arr));
		
		System.out.println("----------- deep copy ----------------");
		System.out.println("a3.i : " + a3.i + "a3.arr : "+ Arrays.toString(a3.arr));
	}
}
