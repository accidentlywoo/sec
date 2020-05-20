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

import com.my.exception.SearchException;
import com.my.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private String fileName;
	
	public CustomerDAOImpl(String fileName) {
		this.fileName = fileName;
	}

	private Customer CustomerFileDataIOStack(Customer customer) throws SearchException {
		// 단건 Customer정보 파일내용 추가 메소드
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		if(CustomerFileDataInputUnique(customer.getId(), "id") != null){
			throw new SearchException("이미 존재하는 정보입니다.");
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
		return customer;
	}
	
	private void CustomerFileDataIOAll(List<Customer> customers) {
		// 파일 내용 전체 다시 입력
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
	
	private List<Customer> CustomerFileDataInputList(){
		// 파일 전체 내용 읽기
		ArrayList<Customer> customers = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			while(true) {
				Customer customer = new Customer();
				customer.setNo(Long.parseLong(dis.readUTF()));
				customer.setId(dis.readUTF());
				customer.setPwd(dis.readUTF());
				customer.setName(dis.readUTF());
				break;
			}
		} catch (IOException e){
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
	
	private List<Customer> CustomerFileDataInputNameList(String name){
		// 파일 전체 내용 읽기
		ArrayList<Customer> customers = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetName;
			while(true) {
				Customer customer = new Customer();
				customer.setNo(Long.parseLong(dis.readUTF()));
				customer.setId(dis.readUTF());
				customer.setPwd(dis.readUTF());
				targetName = dis.readUTF();
				if(targetName.equals(name)) {
					customer.setName(targetName);
					customers.add(customer);
				}
			}
		} catch (IOException e){
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

	private Customer CustomerFileDataInputUnique(String element, String fieldName) throws SearchException{
		// 파일 조건 내용 읽기
		Customer customer = null;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			if(fieldName.equals("id") ) {
				String targetId;
				while(true) {
					customer = new Customer();
					customer.setNo(Long.parseLong(dis.readUTF()));
					targetId = dis.readUTF();
					if(targetId.equals(fieldName)) {
						customer.setId(targetId);
						customer.setPwd(dis.readUTF());
						customer.setName(dis.readUTF());
						break;
					}
				}
			}else if(fieldName.equals("no")) {
				long no;
				while(true) {
					no = Long.parseLong(dis.readUTF());
					if(no == Long.parseLong(fieldName)) {
						customer = new Customer();
						customer.setNo(no);
						customer.setId(dis.readUTF());
						customer.setPwd(dis.readUTF());
						customer.setName(dis.readUTF());
						break;
					}
				}
			}
//			else if(fieldName.equals("name")) {
//				String name;
//				while(true) {
//					customer = new Customer();
//					customer.setNo(Long.parseLong(dis.readUTF()));
//					customer.setId(dis.readUTF());
//					customer.setPwd(dis.readUTF());
//					name = dis.readUTF();
//					if(name.equals(fieldName)) {
//						break;
//					}
//				}
//			}
			else {
				throw new SearchException("찾을 수 없는 정보입니다.");
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
	
	@Override
	public List<Customer> selectAll() throws SearchException {
		List<Customer> result = CustomerFileDataInputList();
		if(result.size()==0) {
			throw new SearchException("파일에 내용이 없습니다.");
		}
		return result;
	}

	@Override
	public Customer selectById(String id) throws SearchException {
		Customer result = CustomerFileDataInputUnique(id,"id");
		if(result == null) {
			throw new SearchException("찾을 수없는 정보입니다.");
		}
		return result;
	}

	@Override
	public Customer selectByNo(long no) throws SearchException {
		Customer result = CustomerFileDataInputUnique(String.valueOf(no),"no");
		if(result == null) {
			throw new SearchException("찾을 수없는 정보입니다.");
		}
		return result;
	}

	@Override
	public List<Customer> selectByName(String name) throws SearchException {
		List<Customer> result = CustomerFileDataInputNameList(name);
		if(result.size() == 0) {
			throw new SearchException("찾을 수없는 정보입니다.");
		}
		return result;
	}

	@Override
	public Customer insert(Customer customer) throws SearchException {
		Customer result = CustomerFileDataInputUnique(customer.getId(),"id");
		if(result == null) {
			throw new SearchException("이미 존재하는 정보입니다.");
		}
		return CustomerFileDataIOStack(customer);
	}

	@Override
	public Customer update(Customer customer) throws SearchException {
		Customer result = CustomerFileDataInputUnique(customer.getId(),"id");
		if(result == null) {
			throw new SearchException("찾을 수없는 정보입니다.");
		}
		List<Customer> customers =  CustomerFileDataInputList();
		customers.remove(result);
		customers.add(customer);
		CustomerFileDataIOAll(customers);
		return result;
	}

	@Override
	public Customer delete(Customer customer) throws SearchException {
		Customer result = CustomerFileDataInputUnique(customer.getId(),"id");
		if(result == null) {
			throw new SearchException("찾을 수없는 정보입니다.");
		}
		List<Customer> customers =  CustomerFileDataInputList();
		customers.remove(result);
		CustomerFileDataIOAll(customers);
		return result;
	}

}
