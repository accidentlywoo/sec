package com.my.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.my.vo.Customer;

public class TCPObjectOutputClient {
	public static void main(String[] args) {
		int port = 8765;
		String serverIp = "192.168.0.115";
		Socket s = null;
		ObjectOutputStream oos = null;
		try {
			s = new Socket(serverIp, port);
			oos = new ObjectOutputStream(s.getOutputStream());
			for(int i = 0; i < 1; i++) {
				Customer customer = new Customer("id"+i, "p", "n", "a");
				oos.writeObject(customer);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
