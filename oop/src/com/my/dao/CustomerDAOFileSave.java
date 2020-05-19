package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.Customer;

public class CustomerDAOFileSave implements CustomerDAO2{
	// 파일에 매번 수정하지 않고, [수정] 과정을 거치면 파일에 저장
	private String fileName;
	final private List<Customer> customers;
	 
	public CustomerDAOFileSave() {
		customers = new ArrayList<Customer>();
	}

	public void insert(Customer customer) throws AddException, DuplicatedException {
		for(Customer c : customers) {
//			if(c.getId().equals(customer.getId())) {
			if(c.equals(customer)) {
				throw new DuplicatedException("이미 존재하는 아이디입니다.");
			}
		}
		customers.add(customer);
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
		try {
			Customer c = selectById(customer.getId());
			c.setId(customer.getId());
			c.setPwd(customer.getPwd());
			c.setName(customer.getName());
			c.setAddr(customer.getAddr());
		} catch (FindException e) {
			throw new ModifyException(e.getMessage());
		}
		
	}
	public void delete(String id) throws RemoveException {
		Customer c = new Customer();
		c.setId(id);
		if(!customers.remove(c)) {
			throw new RemoveException("해당 아이디를 삭제할 수 없습니다."); 
		}
	}
}
