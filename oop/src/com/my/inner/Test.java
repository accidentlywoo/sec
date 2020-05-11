package com.my.inner;
class Outer{
	int i;
	int t;
	public Outer(int t) {
		this.t = t;
	}
	void m() {
		System.out.println(i);
		System.out.println(t);
	}
	
}
public class Test {
	int t;
	void t() {
		t = 99;
		Outer o = new Outer(t);
		o.i = 77;
		o.m();
	}
	class Inner1{
		int innerInstance;
		int t;
		Inner1(){
			System.out.println(innerInstance);
			System.out.println(t);
		}
		void i() {
			this.t = 55;
			// 아우터 클래스의 t 변수값
			Test.this.t = 33;
//			Test.t -> static 필드 접근 잘못된거야 씨벌!
			System.out.println(this.t);
			System.out.println(Test.this.t);
		}
	}
	public static void main(String[] args) {
//		Test t = new Test();
//		t.t();
		new Test().t();
		Test tLocal = new Test();
		tLocal.t();
		
		Test.Inner1 innerLocal= tLocal.new Inner1(); //Test$Inner1
		innerLocal.i();
		
		int mainLocal = 0;
		final int mainLocal2 = 0;
		class Inner2{
			int innerInstance = 0;
			int mainLocal2 = 0;
			void t() {
				System.out.println(innerInstance);
				System.out.println(mainLocal);
				System.out.println(mainLocal2); // -> 조지는 거야!
			}
		}
		new Inner2();//Test$1Inner2
		new Inner2().t();
	}
}
