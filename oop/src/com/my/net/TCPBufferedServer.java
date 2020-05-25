package com.my.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TCPBufferedServer {
	public static void main(String[] args) {
		int port = 6543;
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		try {
			ss = new ServerSocket(port);
			s = ss.accept();
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String[] arr = null;
			int flag = 0;
			do {
				String receive = br.readLine();
				String delim = ":";
				arr = receive.split(delim);
				System.out.println("id = " +  arr[0] + ", name = "+arr[1]);
				flag++;
				if(receive.equals("quit")) {
					break;
				}
			}while(arr.length ==flag);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
