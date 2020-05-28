package com.my.vo;

public class Customer 
              extends Person {	
	private static final long serialVersionUID = 1L;
	private String id;
	transient private String pwd;
	//매개변수없는 생성자
	public Customer() {
		super();
	}
	//매개변수값이 id, pwd인스턴스변수에 대입되는 생성자	
	public Customer(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Customer(String id, String pwd, String name, String addr) {
		//소스코드에 super()호출이나 this()호출코드가 없으면 컴파일시에 super();자동포함됨
		super(name, addr);
		
		this.id = id;
		this.pwd = pwd;
		//this.name = name;
		//super(name, addr);
		//this.setName(name);
		//super.setAddr(addr);
		
	}
	
	//setter/getter메서드
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
		return "id="+id+", pwd="+pwd+", name=" + name+ ", add=" + getAddr();
	}
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
