package com.my.dao;

import java.util.List;

import com.my.exception.SearchException;
import com.my.vo.Customer;

public interface CustomerDAO {
	List<Customer> selectAll() throws SearchException;
	Customer selectById(String id) throws SearchException;
	Customer selectByNo(long no) throws SearchException;
	List<Customer> selectByName(String name) throws SearchException;
	Customer insert(Customer customer) throws SearchException;
	Customer update(Customer customer) throws SearchException;
	Customer delete(Customer customer) throws SearchException;
}
