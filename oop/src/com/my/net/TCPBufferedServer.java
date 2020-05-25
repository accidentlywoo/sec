package com.my.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
			
			while(true) {
				String receive = br.readLine();
				if(receive.equals("quit")) {
					break;
				}
				System.out.println("클라이언트가 보내준 메시지 : "+receive);
			}
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
