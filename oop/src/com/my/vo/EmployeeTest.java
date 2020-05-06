package com.my.vo;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] employees;
		employees = new Employee[10];
		employees[0] = new Employee("no1", "우여니", 1000);
		System.out.println(employees[0].printInfo());
	}
}
