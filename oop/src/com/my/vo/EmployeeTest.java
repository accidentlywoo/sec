package com.my.vo;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] employees;
		employees = new Employee[10];
		employees[0] = new Employee("no1", "우여니", 1000);
		employees[0].printInfo();
		System.out.println("정규직 급여 : "+employees[0].clacTotalSalary());;
		
		employees[1] = new TempEmployee("temp1", "임시직", "물류팀", 100, 5); // Auto Up Casting
		employees[1].printInfo();
		System.out.println(employees[1].getClass().getDeclaredClasses());
		System.out.println("임시직 급여 : " + employees[1].clacTotalSalary()); //clacTotalSalaryTemp
		//System.out.println("임시직 급여 : " + employees[1].clacTotalSalaryTemp());
		if(employees[1] instanceof TempEmployee) {
			TempEmployee te = (TempEmployee) employees[1]; // 강제 Down Casting
			System.out.println("임시직 급여 : " + te.clacTotalSalaryTemp());
		}
		System.out.println("클래스 이름 갖고 오기 : " + employees[1].getClass().getName());
	
		
	}
}
