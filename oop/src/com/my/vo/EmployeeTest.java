package com.my.vo;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] employees;
		employees = new Employee[10];
		employees[0] = new Employee("no1", "우여니", 1000);
		employees[0].printInfo();
		
		employees[1] = new TempEmployee("temp1", "임시직", "물류팀", 100, 0.03);
		employees[1].printInfo();
		System.out.println(employees[1].getClass().getDeclaredClasses());
	}
}
