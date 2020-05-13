package com.my.api;

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
}

public class CloneTest {
	public static void main(String[] args) {
		 // 네트워크 프로그래밍에서 객체 복제작업을 통해 클라이언트에게 지속적인 정보를 제공할때 사용한다.
		A a1 = new A();
		//a1.clone(); The method clone() from the type Object is not visible
		A a2 = a1.shallowCopy();
	}
}
