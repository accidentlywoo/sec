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

/**
 * 제출주소 : ohmoonjeong1@gmail.com
 * 제목 : 각자이름-CustomerDAOFile
 * 내용 : CustomerDAOFile.java소스붙여넣기
 * @author kosta
 */
public class CustomerDAOFile implements CustomerDAO2 {
	private String fileName;
	public CustomerDAOFile() {
		fileName = "customers.dat";
	}
	/**
	 * 파일을 삭제한다
	 */
	private void removeFile() {
		File f = new File(fileName);
		if(f.exists()) {
			f.delete();
		}
	}
	/**
	 * 파일을 만든다
	 * @throws IOException
	 */
	private void createFile() throws IOException{
		File f = new File(fileName);
		if(!f.exists()) { //-->모든 메서드에서 파일없으면 파일생성이 필요하다. 파일생성용 메서드작성!			
			f.createNewFile();
		}
	}
	@Override
	public void insert(Customer c) throws AddException, DuplicatedException {		
		try {
			selectById(c.getId()); //아이디에 해당 고객 찾기
			throw new DuplicatedException(c.getId()+"는 이미 존재하는 아이디입니다");			
		}catch(FindException e) { //아이디에 해당 고객이 없는 경우
			DataOutputStream dos = null;
			File f = new File(fileName);
			try {
				dos = new DataOutputStream( new FileOutputStream(f, true) ); //기존파일에 추가(append)
				dos.writeUTF(c.getId());	dos.writeUTF(c.getPwd());	dos.writeUTF(c.getName()); 	dos.writeUTF(c.getAddr());	
			}catch(FileNotFoundException e1) {
				
			} catch (IOException e1) {
				throw new AddException(e1.getMessage());			
			} finally {
				if(dos != null) {
					try {
						dos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}
			}
		}
	}

	@Override
	public List<Customer> selectAll() throws FindException {
		List<Customer> customers = new ArrayList<>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		File f = new File(fileName);
		try {
			createFile();
			fis = new FileInputStream(f);
			dis = new DataInputStream(fis);
			String id, pwd, name, addr;
			while(true) {
				id = dis.readUTF();
				pwd = dis.readUTF();
				name = dis.readUTF();
				addr = dis.readUTF();
				Customer c = new Customer(id, pwd, name, addr);
				customers.add(c);
			}
		} catch (FileNotFoundException e) {
			try {
				createFile();
			} catch (IOException e1) {
				throw new FindException(e1.getMessage());
			}
		} catch(EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(dis != null)
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(fis != null)
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(customers.size() == 0) {
			throw new FindException("selectAll:고객이 한명도 없습니다");
		}
		return customers;
	}

	@Override
	public Customer selectById(String id) throws FindException {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String id1, pwd, name, addr;
			while(true) {
				id1 = dis.readUTF();
				pwd = dis.readUTF();
				name = dis.readUTF();
				addr = dis.readUTF();
				if(id1.equals(id)) {
					return new Customer(id, pwd, name, addr);
				}
			}
		} catch (FileNotFoundException e) {			
			throw new FindException("selectById:" + e.getMessage());
		} catch(EOFException e) {
			
		} catch (IOException e) {
			throw new FindException("selectById:" + e.getMessage());
		}finally {
			if(dis != null)
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(fis != null)
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new  FindException("selectById: 아이디에 해당하는 고객없습니다");
	}

	@Override
	public List<Customer> selectByName(String word) throws FindException {
		List<Customer> list = new ArrayList<>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			String id, pwd, name, addr;
			while(true) {
				id = dis.readUTF();
				pwd = dis.readUTF();
				name = dis.readUTF();
				addr = dis.readUTF();
				if(name.contains(word)) {
					list.add(new Customer(id, pwd, name, addr));
				}
			}
		} catch (FileNotFoundException e) {
			throw new FindException("selectByName:" + e.getMessage());
			
		} catch(EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new FindException("selectByName:" + e.getMessage());
		}finally {
			if(dis != null)
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(fis != null)
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(list.size() == 0) {
			throw new FindException("selectByName:단어에 해당하는 이름의 고객이 한명도 없습니다");
		}
		return list;
		
	}

	@Override
	public void update(Customer c) throws ModifyException {
		try {
			List<Customer>list = selectAll();
			removeFile();
			for(Customer c1: list) {
				if(c1.equals(c)) {
					if(!c.getPwd().equals("")) {
						c1.setPwd(c.getPwd());
					}				
					if(!c.getPwd().equals("")) {
						c1.setPwd(c.getPwd());
					}
					if(!c.getName().equals("")) {
						c1.setName(c.getName());
					}
					if(!c.getAddr().equals("")) {
						c1.setAddr(c.getAddr());
					}
				}
				insert(c1);
			}
		} catch (FindException e) {
			throw new ModifyException("update:" + e.getMessage());
		} catch (DuplicatedException e) {
			throw new ModifyException("update:" +e.getMessage());
		} catch (AddException e) {
			throw new ModifyException("update:" +e.getMessage());
		} 
	}

	@Override
	public void delete(String id) throws RemoveException {
		try {
			List<Customer> customers = selectAll();
			removeFile();
			Customer c = new Customer();
			c.setId(id);//			
			boolean result = customers.remove(c);
			if(!result) { 
				throw new RemoveException("delete:" + id+"에 해당 고객을 제거하지 못했습니다");
			}
			for(Customer c1: customers) {
				insert(c1);
			}
		} catch (FindException e) {
			//e.printStackTrace();
			throw new RemoveException("delete:" + e.getMessage());
		} catch (DuplicatedException e) {
			throw new RemoveException("delete:" + e.getMessage());
//			e.printStackTrace();
		} catch (AddException e) {
//			e.printStackTrace();
			throw new RemoveException("delete:" + e.getMessage());
		} 

	}
	public static void main(String[] args) {
		CustomerDAO2 dao = new CustomerDAOFile();
//		try {
//			dao.selectAll();
//		} catch (FindException e) {
//			e.printStackTrace();//<----
//		}
//		System.out.println("------------------------");
//		try {
//			dao.insert(new Customer("id1", "p1", "n1", "a1"));//<---
//		} catch (DuplicatedException e) {
//			e.printStackTrace();
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
//		System.out.println("------------------------");
//		try {
//			dao.insert(new Customer("id2", "p2", "n2", "a2")); //<---
//		} catch (DuplicatedException e) {
//			e.printStackTrace();
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
//		System.out.println("------------------------");
//		try {
//			dao.insert(new Customer("id2", "p2", "n2", "a2")); 
//		} catch (DuplicatedException e) {
//			e.printStackTrace();   //<---
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
//		System.out.println("------------------------");
//		Customer c = new Customer("id1", "pu", "nu", "au");
//		try {
//			dao.update(c); //<---
//		} catch (ModifyException e) {
//			e.printStackTrace();
//		} 
//		System.out.println("------------------------");
//		try {
//			System.out.println(dao.selectById("id1")); //id1:pu:nu:au
//		} catch (FindException e) {
//			e.printStackTrace();
//		}
//		System.out.println("------------------------");
//		try {
//			dao.delete("id1"); //<--
//		} catch (RemoveException e) {
//			e.printStackTrace();
//		}
//		System.out.println("------------------------");
		
//		try {
//			System.out.println(dao.selectById("id1")); 
//		} catch (FindException e) {
//			e.printStackTrace(); //<--
//		}
//		System.out.println("------------------------");
	}
}
