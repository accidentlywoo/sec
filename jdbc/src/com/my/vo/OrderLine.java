package com.my.vo;

public class OrderLine {
	private int order_no;
	//private String order_prod_no;
	private Product order_p;
	private int order_quantity;
	// Has A 관계를 잘 구현하면 Java Persistance 상태를 구현할 수 있다
	// DB와 Java와의 영속적인 관계
}
