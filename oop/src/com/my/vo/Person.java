package com.my.vo;

public class Person {
	//private String name;
	protected String name;
	private String addr;
	
	public Person() {
		System.out.println("Pereson() Constructor Called");
	}
	public Person(String name, String addr) {
		System.out.println("Pereson(String, String) Constructor Called");
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
}