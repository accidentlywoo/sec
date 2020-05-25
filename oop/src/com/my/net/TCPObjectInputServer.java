package com.my.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPObjectInputServer {
	public static void main(String[] args){
		int port = 8765;
		ServerSocket ss = null;
		Socket s = null;
		ObjectInputStream ois = null;
		try {
			ss = new ServerSocket(port);
			s = ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
			
			while(true) {
				Object receive = ois.readObject();
				System.out.println("클라이언트가 보낸 메세지 : " + receive);
			}
		}catch (BindException e) {
			System.out.println(port + "이미 사용중인 포트입니다.");
		}catch (SocketException e) {
			// 반복문이 계속되면서 발생
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
