package com.my.dao;

import java.util.List;

import com.my.domain.CustomerPrivateInfo;
import com.my.vo.Customer;

public interface CustomerDAO {
	public void insertCustomer(Customer customer);
	public List<Customer> selectAll();
	public Customer selectById(String id);
	public Customer selectByIdEmail(String id, String email);
	public Customer updateName(String id);
	public Customer updateNamePhoneEmail(CustomerPrivateInfo customerInfo);
}
