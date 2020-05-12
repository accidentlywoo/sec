package com.my.service;

import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOArray;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CustomerService {
	private CustomerDAO customerDAO;
	public CustomerService() {
		customerDAO = new CustomerDAOArray();
	}
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	// 기능 구현 시작
	public void add(Customer customer) throws AddException{
		customerDAO.insert(customer);
	}
	
	public Customer[] findAll() throws FindException{
		return customerDAO.selectAll();
	}
	
	public Customer findById(String id) throws FindException{ 
		return customerDAO.selectById(id);
	}

	public Customer[] findByName(String name) throws FindException{ 
		return null;
	}
	
	public void login(String id, String pwd) throws FindException{
		try { 
			Customer customer = customerDAO.selectById(id);
			if(!customer.getPwd().equals(pwd)) {
				throw new FindException("로그인 실패");
			}
		} catch (FindException e) {
			throw new FindException("로그인 실패");
		}
//		Customer c;
//		try {
//			c = customerDAO.selectById(id);
//		} catch (FindException e) {
//			throw new FindException("로그인 실패");
//		}
//		
//		try {
//			if(!c.getPwd().equals(pwd)) {
//				throw new FindException("로그인 실패");
//			}
//		} catch (FindException e) {
//			throw new FindException("로그인 실패");
//		}
		System.out.println("로그인 성공");
	}
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		try {
			customerService.findAll();
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		try {
			customerService.add(new Customer("id1", "p1","n1","a1"));
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		try {
			Customer result = customerService.findById("id1");
			System.out.println(result);
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		try {
			customerService.login("id1", "p1");
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		try {
			customerService.login("idㅁㅁㅁㅁ", "p1");
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		try {
			customerService.login("id1", "p22231");
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
}
