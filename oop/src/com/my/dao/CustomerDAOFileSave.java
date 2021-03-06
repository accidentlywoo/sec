package com.my.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private List<Customer> customers = new ArrayList<Customer>();
	 
	public CustomerDAOFileSave() {
		fileName = "customers.dat";
	}

	public void insert(Customer customer) throws AddException, DuplicatedException, FindException {
		if(customers.size() == 0){
			customers.add(customer);
			return;
		}
		for(Customer c : customers) {
			if(c.equals(customer)) {
				throw new DuplicatedException("이미 존재하는 아이디입니다.");
			}
		}
		customers.add(customer);
	}

	public List<Customer> selectAll() throws FindException {
		customers = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			while(true) {
				Customer customer = new Customer();
				customer.setId(dis.readUTF());
				customer.setPwd(dis.readUTF());
				customer.setName(dis.readUTF());
				customer.setAddr(dis.readUTF());
				customers.add(customer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return customers;
	}

	public Customer selectById(String id) throws FindException {
		if(customers.size() == 0){
			throw new FindException("등록 고객이 없습니다.");
		}
		for(Customer customer : customers) {
			if(customer.getId().equals(id)) {
				return customer;
			}
		}
		throw new FindException("해당 아이디의 고객을 찾을 수 없습니다");
	}

	public List<Customer> selectByName(String word) throws FindException {
		if(customers.size() == 0){
			throw new FindException("등록 고객이 없습니다.");
		}
		List<Customer> result = new ArrayList<Customer>();
		for(Customer customer : customers) {
			if(customer.getName().contains(word)) {
				result.add(customer);
			}
		}
		if(result.size() == 0) {
			throw new FindException("해당 글자가 포함된 아이디는 없습니다.");
		}
		return result;
	}

	public void update(Customer customer) throws ModifyException, FindException {
		if(customers.size() == 0){
			return;
		}
		selectById(customer.getId());
		customers.remove(customer);
		Customer result = new Customer();
		result.setId(customer.getId());
		result.setPwd(customer.getPwd());
		result.setName(customer.getName());
		result.setAddr(customer.getId());
		customers.add(result);
	}
	public void delete(String id) throws RemoveException {
		if(customers.size() == 0){
			return;
		}
		Customer c = new Customer();
		c.setId(id);
		if(!customers.remove(c)) {
			throw new RemoveException("해당 아이디를 삭제할 수 없습니다."); 
		}
	}
	public void insertFile() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			if(customers.size() == 0){
				return;
			}
			for(Customer item : customers) {
				dos.writeUTF(item.getId());
				dos.writeUTF(item.getPwd());
				dos.writeUTF(item.getName());
				dos.writeUTF(item.getAddr());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
