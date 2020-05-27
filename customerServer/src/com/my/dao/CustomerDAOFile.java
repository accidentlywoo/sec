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
import java.util.Optional;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.Customer;

public class CustomerDAOFile implements CustomerDAO2{
	// 메소드 호출시마다 FileIO 통제.
	private String fileName;
	 
	public CustomerDAOFile() {
		fileName = "customers.dat";
	}

	private synchronized void CustomerFileDataOutputList(List<Customer> result){
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			for(Customer item : result) {
				dos.writeUTF(item.getId());
				dos.writeUTF(item.getPwd());
				dos.writeUTF(item.getName());
				dos.writeUTF(item.getAddr());
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
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
	
	private synchronized void CustomerFileDataOutput(Customer customer) throws FindException {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		if(CustomerFileDataInput(customer.getId()) != null){
			throw new FindException("이미 존재하는 정보입니다.");
		}
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
	}

	private synchronized List<Customer> CustomerFileDataInputList(Optional<String> word){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			while(true) {
				if(word == null){
					Customer customer = new Customer();
					customer.setId(dis.readUTF());
					customer.setPwd(dis.readUTF());
					customer.setName(dis.readUTF());
					customer.setAddr(dis.readUTF());
					customers.add(customer);
				}else{
					Customer customer = new Customer();
					customer.setId(dis.readUTF());
					customer.setPwd(dis.readUTF());
					String targetName = dis.readUTF();
					if(targetName.contains(word.orElseGet(String::new))){
						customer.setName(targetName);
						customer.setAddr(dis.readUTF());
						break;
					}else {
						throw new FindException("찾는 아이디는 없습니다.");
					}
				}
			}
		} catch (IOException e){
		}catch (FindException e) {
			e.printStackTrace();
		} finally {
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

	private synchronized Customer CustomerFileDataInput(String id){
		Customer customer = null;

		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetId;
			while(true) {
				targetId = dis.readUTF();
				if(targetId.equals(id)) {
					customer = new Customer();
					customer.setId(targetId);
					customer.setPwd(dis.readUTF());
					customer.setName(dis.readUTF());
					customer.setAddr(dis.readUTF());
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
		return customer;
	}

	public Customer insert(Customer customer) throws AddException, DuplicatedException, FindException {
		CustomerFileDataOutput(customer);
		return customer;
	}

	public List<Customer> selectAll() throws FindException {
		List<Customer> customers = CustomerFileDataInputList(null);
		if(customers.size() == 0) {
			throw new FindException("저장소가 없습니다.");
		}
		return customers;
	}


	public Customer selectById(String id) throws FindException {
		Customer customer = CustomerFileDataInput(id);
		if(customer == null){
			throw new FindException("해당 아이디를 찾을 수 없습니다.");
		}
		return customer;
	}

	public List<Customer> selectByName(String word) throws FindException {
		return CustomerFileDataInputList(Optional.ofNullable(word));
	}

	public void update(Customer customer) throws ModifyException, FindException {
		List<Customer> result = CustomerFileDataInputList(null);
		result.remove(customer);
		result.add(customer);
		CustomerFileDataOutputList(result);
	}

	public void delete(String id) throws RemoveException, FindException {
		List<Customer> result = CustomerFileDataInputList(null);
		result.remove(CustomerFileDataInput(id));
		CustomerFileDataOutputList(result);
	}
}
