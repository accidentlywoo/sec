package com.my.vo;

import java.io.Serializable;

public class Person
             implements Serializable{	
	private static final long serialVersionUID = 1L;
	//private String name;
	protected String name;
	private String addr;
	public Person() {
		super();
		System.out.println("Person()생성자 호출됨");
		
	}
	public Person(String name, String addr) {
		super();
		System.out.println("Person(String,String)생성자 호출됨");
		this.name = name;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void printInfo() {
		System.out.println(name + ":"+ addr);
	}
	
}
