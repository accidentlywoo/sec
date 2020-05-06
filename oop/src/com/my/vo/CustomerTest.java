package com.my.vo;

public class CustomerTest {
	public static void main(String[] args) {
		Person p;
//		p = new Person();
//		//p,name = "홍길동";
//		p.setName("홍길동");
//		p.setAddr("경기도 성남시 유플레이스B");

		p = new Person("엉길동", "경기도 성남시");
		
		Customer c;
//		c = new Customer();
//		c.setName("고객");
//		c.setAddr("경기도 성남시");
//		c.setId("id1");
//		c.setPwd("p1");
		c = new Customer("id1", "p1");
		Customer c2 = new Customer("id2", "p2", "고객1", "경기도 성남시");
		System.out.println(c);
	}
}
