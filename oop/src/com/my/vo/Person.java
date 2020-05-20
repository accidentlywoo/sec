package com.my.vo;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String name;
	protected String name;
	private String addr;
	
	public Person() {
	}
	public Person(String name, String addr) {
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
		System.out.println("Person [name=" + name + ", addr=" + addr + "]");
	}
}