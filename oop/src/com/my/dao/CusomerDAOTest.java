package com.my.dao;

import java.util.Arrays;

import com.my.vo.Customer;

public class CusomerDAOTest {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		Customer customer = new Customer();
		customer.setAddr("a");
		customer.setId("1");
		customer.setName("a");
		customer.setPwd("a");
		dao.insert(customer);
		
		Customer customer2 = new Customer();
		customer2.setAddr("b");
		customer2.setId("2");
		customer2.setName("b");
		customer2.setPwd("b");
		dao.insert(customer2);
		
		dao.selectAll();
		System.out.println("select by id : " + dao.selectById("1"));
		System.out.println("select by id : " + dao.selectById("3"));
	}
}
