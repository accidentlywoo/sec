package com.my.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.my.dao.CustomerDAO2;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.share.CustomerShare;
import com.my.vo.Customer;

public class CustomerService2 {
	private CustomerDAO2 dao;
	public CustomerService2() {
		//dao = new CustomerDAOList();
		//dao = new CustomerDAOFile();
		//dao = new CustomerDAOOracle();
		
		//dao������ ������ ���� �ܺ�customer.properties������
		//                     daoŰ�� �ش��ϴ� ���̴�		
		try {
			//1)�ܺ�customer.properties������ key,value�� �ε�
			Properties env = new Properties();
			env.load(new FileInputStream("customer.properties"));
		
			//2)env�� property value���(key�� "dao")
			String daoClassName = env.getProperty("dao");
		
			//3)daoClassName�� �ش��ϴ� Ŭ�����ε�
			Class clazz = Class.forName(daoClassName);
			
			//4) 3)�۾����� �α��� Ŭ����Ÿ����  ��ü����
			Object obj = clazz.newInstance();
			
			//5) ��ü�� �ν��Ͻ����� dao�� ����
			dao = (CustomerDAO2)obj;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public CustomerService2(CustomerDAO2 dao) {
		this.dao = dao;
	}
	public CustomerDAO2 getDao() {
		return dao;
	}
	public void setDao(CustomerDAO2 dao) {
		this.dao = dao;
	}
	
	public void add(Customer c) throws AddException{
		dao.insert(c);
	}
	public List<Customer> findAll() throws FindException{
		return dao.selectAll();
	}
	public Customer findById(String id) throws FindException{ 
		return dao.selectById(id); 
	}
	public List<Customer> findByName(String word) throws FindException{ 
		return dao.selectByName(word);
	}
	public void login(String id, String pwd) throws FindException{
		Customer c; 
		try {
			c = dao.selectById(id);
			CustomerShare.loginedCustomer = c; //�α��ε� ����ü�� ����
		}catch(FindException e) {
			throw new FindException("�α��� ����");
		}
		
		if(!c.getPwd().equals(pwd)) {
			throw new FindException("�α��� ����");
		}
	}	
	public void modify(Customer c) throws ModifyException {
		dao.update(c);
	}
	public void remove(String id) throws RemoveException {
		dao.delete(id);
	}
}
