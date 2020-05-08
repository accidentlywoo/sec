package com.my.dao;

import java.util.Arrays;

import com.my.vo.Customer;

public class CustomerDAOArrayImpl implements CustomerDAO{
	private Customer[] customers; // 고객 정보
	private int cnt; // 저장된 고객 수
	public final static int MAX_CNT = 10; //최대 고객수

	public CustomerDAOArrayImpl() {
		this.customers = new Customer[MAX_CNT];
	}
	public void insert(Customer customer) {
		this.customers[cnt] = customer;
		System.out.println("cnt : "+ this.cnt + ", array : "+ this.customers[cnt]);
		System.out.println(customer.toString());
		setCnt(this.cnt=cnt+1);
	}
	public void selectAll() {
		Customer[] cc = Arrays.copyOf(this.customers, cnt);
		// System.arraycopy(customers, 0, cc, 0, cnt);
		System.out.println(Arrays.toString(cc));
	}
	
	public Customer selectById(String id) {
		for(int i = 0; i < cnt; i++) {
			Customer c = customers[i];
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Customer[] getCustomers() {
		return customers;
	}
}
