package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.Customer;

public class CustomerDAOList implements CustomerDAO2{
	final private List<Customer> customers;
	
	public CustomerDAOList() {
		customers = new ArrayList<Customer>();
	}

	public void insert(Customer customer) throws AddException, DuplicatedException {
		for(Customer c : customers) {
//			if(c.getId().equals(customer.getId())) {
			if(c.equals(customer)) {
				throw new DuplicatedException("이미 존재하는 아이디입니다.");
			}
		}
	}

	public List<Customer> selectAll() throws FindException {
		if(customers.size() == 0) {
			throw new FindException("등록된 고객이 없습니다.");
		}
		return customers;
	}

	public Customer selectById(String id) throws FindException {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new FindException("해당 아이디의 고객을 찾을 수 없습니다");
	}

	public List<Customer> selectByName(String word) throws FindException {
		List<Customer> result = new ArrayList<Customer>();
		for(Customer c : customers) {
			if(c.getName().contains(word)) {
				result.add(c);
			}
		}
		if(result.size() == 0) {
			throw new FindException("해당 글자가 포함된 아이디는 없습니다.");
		}
		return result;
	}

	public void update(Customer customer) throws ModifyException {
		
	}
	public void delete(String id) throws RemoveException {
//		for(Customer c : customers) {
//			if(c.getId().equals(id)) {
//				customers.remove(c); //remove 메소드의 내부 구현을 이해하고 equals를 오버라이딩 해보자
//				return;
//			}
//		}
		Customer c = new Customer();
		c.setId(id);
		if(!customers.remove(c)) {
			throw new RemoveException("해당 아이디를 삭제할 수 없습니다."); 
		}
	}
}
