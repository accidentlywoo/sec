package com.my.vo;

public class Customer extends Person{
	private String id;
	private String pwd;
	public Customer() {
		// super(); 컴파일 시점에 자동 추가됨
	}
	public Customer(String id, String pwd) {
		// super(); 컴파일 시점에 자동 추가됨
		this.id = id;
		this.pwd = pwd;
	}
	
	public Customer(String id, String pwd, String name, String addr) {
		/*
		 * 소스코드에 super() 호출이나 this() 호출 코드가 없으면 컴파일시에 
		 *  super();자동 추가됨
		 */
		super(name, addr);
		/*
		 * this.setName(name);
		 * super.setName(addr);
		 */
		this.id = id;
		this.pwd = pwd;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pwd=" + pwd + ", getName=" + getName() + ", getAddr=" + getAddr() + "]";
	}
	// System 클래스의 Println() 메소드에서 valueof의 변형과 toString의 관계를 파보기
}
