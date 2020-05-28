package com.my.io;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.my.vo.Customer;

public class DataIO {
	private DataOutputStream dos;
	private DataInputStream dis;	
	public DataIO(DataOutputStream dos, DataInputStream dis) {
		super();
		this.dos = dos;
		this.dis = dis;
	}
	public void sendSuccess() throws IOException{
		dos.writeUTF("success");
	}
	public void sendSuccess(String msg) throws IOException {
		dos.writeUTF("success");
		dos.writeUTF(msg);
	}
	
	public void sendFail(String msg) throws IOException {
		dos.writeUTF("fail");
		dos.writeUTF(msg);
	}
	
	public void send(String str) throws IOException {
		dos.writeUTF(str);
	}
	public void send(int gubun) throws IOException {
		dos.writeInt(gubun);
	}
	public void send(Customer c) throws IOException {
		dos.writeUTF(c.getId());
		dos.writeUTF(c.getPwd());
		dos.writeUTF(c.getName());
		dos.writeUTF(c.getAddr());
	}
	public void send(List<Customer> list) throws IOException {
		for(Customer c: list) {
			send(c);
		}
	}
	
	public String receiveStatus() throws IOException {
		return dis.readUTF();
	}
	public String receive() throws IOException {
		return dis.readUTF();
	}
	public int receiveInt() throws IOException{
		return dis.readInt();
	}	
	public Customer receiveCustomer() throws IOException {
		String id = dis.readUTF();
		String pwd = dis.readUTF();
		String name = dis.readUTF();
		String addr = dis.readUTF();
		return new Customer(id, pwd, name, addr);
	}
	public List<Customer> receiveCustomers(int size) throws IOException {
		List<Customer> list = new ArrayList<>();
		for(int i=0; i<size; i++) {
			list.add(receiveCustomer());
		}
		return list;
	}
	public void close() {
		if(dos != null)
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dis != null)
		try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
