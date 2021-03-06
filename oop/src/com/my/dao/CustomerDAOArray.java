package com.my.dao;

import java.util.Arrays;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CustomerDAOArray implements CustomerDAO{
	private Customer[] customers; // 고객 정보
	private int cnt; // 저장된 고객 수
	public final static int MAX_CNT = 10; //최대 고객수

	public CustomerDAOArray() {
		this.customers = new Customer[MAX_CNT];
	}
	public void insert(Customer customer) throws DuplicatedException, AddException{
		for(int i = 0; i < cnt; i++) {
			if(customers[i].getId().equals(customer.getId())) {
				throw new DuplicatedException(customer.getId() + " : 는 이미 존재하는 아이디 입니다.");
			}
		}
		try {
			this.customers[cnt] = customer;
			setCnt(this.cnt=cnt+1);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new AddException("저장소가 꽉 참");
		}
	}
	public Customer[] selectAll() throws FindException {
		if(cnt == 0) {
			throw new FindException("고객이 한명도 없습니다.");
		}
		Customer[] cc = Arrays.copyOf(this.customers, cnt);
		// System.arraycopy(customers, 0, cc, 0, cnt);
		System.out.println(Arrays.toString(cc));
		return null;
	}
	
	public Customer selectById(String id) throws FindException {
		for(int i = 0; i < cnt; i++) {
			Customer c = customers[i];
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new FindException("아이디에 해당하는 고객이 없습니다");
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
	@Override
	public Customer[] selectByName(String cs) throws FindException {
		int wordCnt = 0;
		boolean[] flags = new boolean[cnt];
		for(int i = 0; i < cnt; i++) {
			Customer c = customers[i];
			String name = c.getName();
			if(name.contains(cs)) {
				flags[i] = true;
				wordCnt++;
			}else {
				flags[i] = false;
			}
		}
		if(wordCnt == 0) {
			throw new FindException(cs+"단어를 포함하는 이름이 없습니다.");
		}
		Customer[] arr = new Customer[wordCnt];
		int index = 0;
		for(int i = 0; i < cnt; i++) {
			if(flags[i]) {
				arr[index] = customers[i];
				index++;
			}
		}
		return arr;
	}
}
