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
		
		//dao변수에 대입할 값은 외부customer.properties파일의
		//                     dao키에 해당하는 값이다		
		try {
			//1)외부customer.properties파일의 key,value를 로드
			Properties env = new Properties();
			env.load(new FileInputStream("customer.properties"));
		
			//2)env의 property value얻기(key는 "dao")
			String daoClassName = env.getProperty("dao");
		
			//3)daoClassName에 해당하는 클래스로드
			Class clazz = Class.forName(daoClassName);
			
			//4) 3)작업으로 로그한 클래스타입의  객체생성
			Object obj = clazz.newInstance();
			
			//5) 객체를 인스턴스변수 dao에 대입
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
			CustomerShare.loginedCustomer = c; //로그인된 고객객체를 공유
		}catch(FindException e) {
			throw new FindException("로그인 실패");
		}
		
		if(!c.getPwd().equals(pwd)) {
			throw new FindException("로그인 실패");
		}
	}	
	public void modify(Customer c) throws ModifyException {
		dao.update(c);
	}
	public void remove(String id) throws RemoveException {
		dao.delete(id);
	}
}
