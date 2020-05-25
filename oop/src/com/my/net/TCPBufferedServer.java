package com.my.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
			while(true) {
				String receive = br.readLine();
				String delim = ":";
				arr = receive.split(delim);
				System.out.println("id = " +  arr[0] + ", name = "+arr[1]);
				if(receive.equals("quit")) {
					break;
				}
			}
		}catch (BindException e) {
			System.out.println(port + "이미 사용중인 포트입니다.");
		}catch (SocketException e) {
			// 반복문이 계속되면서 발생
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
