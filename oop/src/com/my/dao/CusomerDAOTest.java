package com.my.dao;

import java.util.Arrays;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CusomerDAOTest {
	public static void main(String[] args) {
		CustomerDAOArray dao = new CustomerDAOArray();
		Customer customer = new Customer();
		customer.setAddr("a");
		customer.setId("1");
		customer.setName("a");
		customer.setPwd("a");
		try {
			dao.insert(customer);
		} catch (DuplicatedException e) {
			e.printStackTrace();
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		try {
			dao.insert(new Customer("b","2","b","b"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		} catch (AddException e) {
			e.printStackTrace();
		}
		try {
			for(int i = 2; i <= 20; i ++) {
					dao.insert(new Customer("b"+i,"b"+i,"b"+i,"b"+i));
			}
		} catch (DuplicatedException e) {
			e.printStackTrace();
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		try {
			dao.insert(new Customer("b","2","b","b"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		try {
			dao.selectAll();
		} catch (FindException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("select by id : " + dao.selectById("1"));
		} catch (FindException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("select by id : " + dao.selectById("3"));
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
}
