package com.my.view;
import java.util.List;
import com.my.vo.Customer;

public class SuccessView {
	private static SuccessView success = new SuccessView();
	private SuccessView() {}
	public static SuccessView getInstance() {
		return success;
	}
	public void addCustomerView(String message) {
		System.out.println(message);		
	}
	public void findAllCustomerView(List<Customer> list) {
		for(Customer c: list) {
			System.out.println(c);
		}
	}
	public void findByIdCustomerView(Customer c) {
		System.out.println(c);
	}
	public void loginCustomerView(String message) {
		System.out.println(message);
	}
	public void modifyCustomerView(String message) {
		System.out.println(message);
	}
}
