package com.my.vo;

public class Employee extends Person{
	private String no;
	private String dept;
	private int salary;
	private double comm;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String no, int salary) {
		this(name, no, null, salary);
	}

	public Employee(String name, String no, String dept, int salary) {
		this(name, no, dept, salary, 0.0);
	}
	public Employee(String name,String no, String dept, int salary, double comm) {
		//this.setName(name);
		this.name = name;
		this.no = no;
		this.dept = dept;
		this.salary = salary;
		this.comm = comm;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public String printInfo() {
		return "Employee [no=" + no + ", dept=" + dept + ", salary=" + salary + ", comm=" + comm + "]";
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", dept=" + dept + ", salary=" + salary + ", comm=" + comm + "]";
	}

	
}
