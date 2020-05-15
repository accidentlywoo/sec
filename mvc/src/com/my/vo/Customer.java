package com.my.vo;

public class Customer {

	private long no;
	private String id;
	private String pwd;
	
	private String name;
	private String phoneNumber;
	private String email;
	private String addr;
	
	private long point;
	private long like;
	private long hate;
	
	private boolean sms;
	private boolean emailReception;
	
	public String getId() {
		return id;
	}
	public long getNo() {
		return no;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	public Customer() {
	}
	
	
	public Customer(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	public Customer(String id, String pwd, String name, String phoneNumber, String email, String addr) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addr = addr;
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
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public long getLike() {
		return like;
	}
	public void setLike(long like) {
		this.like = like;
	}
	public long getHate() {
		return hate;
	}
	public void setHate(long hate) {
		this.hate = hate;
	}
	public boolean isSms() {
		return sms;
	}
	public void setSms(boolean sms) {
		this.sms = sms;
	}
	public boolean isEmailReception() {
		return emailReception;
	}
	public void setEmailReception(boolean emailReception) {
		this.emailReception = emailReception;
	}
	public void setNo(long no) {
		this.no = no;
	}
	
}
