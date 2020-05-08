package com.my.dao;

import com.my.vo.Customer;

public interface CustomerDAO {
	void insert(Customer customer);
	void selectAll();
	Customer selectById(String id);
}
