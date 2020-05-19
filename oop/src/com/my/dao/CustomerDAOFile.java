package com.my.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
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

public class CustomerDAOFile implements CustomerDAO2{
	// 메소드 호출시마다 FileIO 통제.
	private String fileName;
	private List<Customer> customers = new ArrayList<Customer>();
	 
	public CustomerDAOFile() {
		fileName = "customers.dat";
	}
	public void insert(Customer customer) throws AddException, DuplicatedException, FindException {
		selectAll();
		for(Customer item : customers) {
			if(item.equals(customer)) {
				throw new DuplicatedException("이미 존재하는 아이디입니다.");
			}
		}
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName,true);
			dos = new DataOutputStream(fos);
			
			dos.writeUTF(customer.getId());
			dos.writeUTF(customer.getPwd());
			dos.writeUTF(customer.getName());
			dos.writeUTF(customer.getAddr());
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
		System.out.println("가입 정보 : "+ customer);
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
		selectAll();
		for(Customer customer : customers) {
			if(customer.getId().equals(id)) {
				return customer;
			}
		}
		throw new FindException("해당 아이디의 고객을 찾을 수 없습니다");
	}

	public List<Customer> selectByName(String word) throws FindException {
		selectAll();
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
		selectAll();
		selectById(customer.getId());
		// ??? 지우기 어쨰함?
		customers.remove(customer);
		Customer result = new Customer();
		result.setId(customer.getId());
		result.setPwd(customer.getPwd());
		result.setName(customer.getName());
		result.setAddr(customer.getId());
		customers.add(result);
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
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
	public void delete(String id) throws RemoveException, FindException {
		selectAll();
	}
	
}
