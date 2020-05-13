package com.my.api;

class A{
	int i = 1;
	int[] arr = {1, 2, 3};
	public void shallowCopy() throws CloneNotSupportedException {
		this.clone();
	}
}

public class CloneTest {
	public static void main(String[] args) {
		 // 네트워크 프로그래밍에서 객체 복제작업을 통해 클라이언트에게 지속적인 정보를 제공할때 사용한다.
		A a1 = new A();
		a1.clone();
		// The method clone() from the type Object is not visible
		// visible -> 접근 제한자 표현
		// clone()이 Object에서 protected로 선언되어있다. 
		// 인스턴스에서 접근할 수 없고, 하위 클래스에서 접근해야 한다.
	}
}
