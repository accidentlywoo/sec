package com.my.vo;

public class Customer extends Person{
	private static final long serialVersionUID = 1L;
	private String id;
	transient private String pwd; // 객체 직렬화 대상 제외
	public Customer() {
		// super(); 컴파일 시점에 자동 추가됨
	}
	public Customer(String id, String pwd) {
		// super(); 컴파일 시점에 자동 추가됨
		this.id = id;
		this.pwd = pwd;
	}
	public Customer(String id, String pwd, String name) {
		this(id, pwd);
		this.name = name;
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
		return "Customer [id=" + id + ", pwd=" + pwd + ", getName=" + getName() + ", getAddr=" + getAddr() + "]"+"\n";
	}
	// System 클래스의 Println() 메소드에서 valueof의 변형과 toString의 관계를 파보기
	/**
	 * Customer id값을 비교
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
