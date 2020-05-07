package com.my.vo;

public class TempEmployee extends Employee {
	private int time;

	
	public TempEmployee() {
	}
	
	public TempEmployee(String name, String no, int salary) {
		super(name, no, salary);
	}
	
	
	public TempEmployee(String name, String no, String dept, int salary, double comm) {
		super(name, no, dept, salary, comm);
	}

	public TempEmployee(String name, String no, String dept, int salary) {
		super(name, no, dept, salary);
	}
	
	public TempEmployee(String name,
									 String no,
									 String dept,
									 int salary,
									 int time) {
		super(name, no, dept, salary);
		this.time = time;
	}

	public TempEmployee(int time) {
		super();
		this.time = time;
	}
	

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public double clacTotalSalary() {
		return getSalary() * time;
	}
	
//	public double clacTotalSalaryTemp() {
//		return getSalary() * time;
//	}
}
