package com.my.controll;

import java.util.List;

import com.my.domain.CustomerPrivateInfo;
import com.my.domain.CustomerPublicInfo;
import com.my.service.CustomerService;
import com.my.vo.Customer;

public class CustomerController {
	private CustomerService customerService;
	
	public List<Customer> customerList() {return null;}
	public CustomerPublicInfo findCustomerById(String id) {return null;}
	public CustomerPrivateInfo findCustomerByIdEmail(String id, String email) {return null;}
	public void join(Customer customer) {}
	public CustomerPrivateInfo login(String id, String pwd) {return null;}
	public CustomerPublicInfo logout() {return null;}
}
