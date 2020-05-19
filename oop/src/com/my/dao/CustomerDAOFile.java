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

public class CustomerDAOFile implements CustomerDAO2{
	// 메소드 호출시마다 FileIO 통제.
	private String fileName;
	 
	public CustomerDAOFile() {
		fileName = "customers.dat";
	}
	public void insert(Customer customer) throws AddException, DuplicatedException{
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetId;
			while(true) {
				targetId = dis.readUTF();
				
				if(customer.getId().equals(targetId)) {
					throw new DuplicatedException("이미 존재하는 아이디입니다.");
				}
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
		ArrayList<Customer> customers = new ArrayList<Customer>();
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
		Customer customer = null;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetId;
			while(true) {
				targetId = dis.readUTF();
				if(targetId == id) {
					customer = new Customer();
					customer.setId(targetId);
					customer.setPwd(dis.readUTF());
					customer.setName(dis.readUTF());
					customer.setAddr(dis.readUTF());
					break;
				}
			}
			if(customer == null) {
				throw new FindException("해당아이디는 없습니다.");
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
		return customer;
	}

	public List<Customer> selectByName(String word) throws FindException {
		List<Customer> result = new ArrayList<Customer>();
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		Customer customer = new Customer();
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetName;
			while(true) {
				customer.setId(dis.readUTF());
				customer.setPwd(dis.readUTF());
				targetName = dis.readUTF();
				if(targetName.contains(word)) {
					customer.setName(targetName);
					customer.setAddr(dis.readUTF());
					result.add(customer);
				}
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
		if(result.size() == 0) {
			throw new FindException("해당 글자가 포함된 아이디는 없습니다.");
		}
		return result;
	}

	public void update(Customer customer) throws ModifyException, FindException {
		List<Customer> result = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		Customer targetCustomer = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetId;
			while(true) {
				targetCustomer = new Customer();
				targetId = dis.readUTF();
				
				targetCustomer.setId(targetId);
				targetCustomer.setPwd(dis.readUTF());
				targetCustomer.setName(dis.readUTF());
				targetCustomer.setAddr(dis.readUTF());
				if(!customer.equals(targetId)) {
					result.add(targetCustomer);
				}
				result.add(customer);
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
		List<Customer> result = new ArrayList<Customer>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		Customer customer = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String targetId;
			while(true) {
				customer = new Customer();
				customer.setId(dis.readUTF());
				customer.setPwd(dis.readUTF());
				targetId = dis.readUTF();
				if(targetId != id) {
					customer.setName(targetId);
					customer.setAddr(dis.readUTF());
					result.add(customer);
				}
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
