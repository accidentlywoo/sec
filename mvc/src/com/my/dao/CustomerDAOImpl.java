package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import com.my.domain.CustomerPrivateInfo;
import com.my.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO{
//	private final Customer customer = new Customer(); DB 연결시..
	private List<Customer> customers;
	

	public CustomerDAOImpl() {
		this.customers = new ArrayList<Customer>();
	}

	public void insertCustomer(Customer customer) {
		//customer validation check
		this.customers.add(customer);
	}

	public List<Customer> selectAll() {
		return null;
	}

	public Customer selectById(String id) {
		return null;
	}

	public Customer selectByIdEmail(String id, String email) {
		return null;
	}

	public Customer updateName(String id) {
		return null;
	}

	public Customer updateNamePhoneEmail(CustomerPrivateInfo customerInfo) {
		return null;
	}

}
