package com.my.control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.io.DataIO;
import com.my.service.CustomerService2;
import com.my.share.CustomerShare;
import com.my.vo.Customer;

public class CustomerControl {
	private CustomerService2 service;
	private static CustomerControl ctr = new CustomerControl();
	
//	private DataOutputStream dos;
//	private DataInputStream dis;	
	
	private CustomerControl() {
		service = new CustomerService2(); 
	}
	
	

	public static CustomerControl getInstance() {
		return ctr;
	}
	

	
	public void addControl(Customer c) throws AddException{		
		
			service.add(c);
	}
	public List<Customer> findAllControl() throws FindException{
		return service.findAll();
	}

	public Customer findByIdControl(String id) throws FindException {
		return service.findById(id);
	}
	public void loginControl(String id, String pwd) throws FindException{
		service.login(id, pwd);				
	}
	public Customer infoControl(String id) throws FindException {
		return findByIdControl(id);
	}
	public void modifyControl(Customer c) throws ModifyException {
		service.modify(c);
	}
	public void removeControl(String id) throws RemoveException {
		//service.remove(CustomerShare.loginedCustomer.getId());			
		service.remove(id);
	}
	public void logoutControl() throws IOException{
		//CustomerShare.loginedCustomer = null;
		
//		sendSuccess("로그아웃 성공");
	}

}
