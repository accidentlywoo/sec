package com.my.net;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPBroadcastMultiServer {
	public static void main(String[] args) {
		int port = 1234;
		ServerSocket ss = null;
		Socket s = null;
		List<BroadcastServerThread> list = new ArrayList<BroadcastServerThread>();
		try {
			ss = new ServerSocket(port); // BindException
			while(true) {
				s = ss.accept();
//				System.out.println("접속했습니다."); 이 메세지를 broadcasting 하자!
//				new BroadcastServerThread(list,s).start();
				BroadcastServerThread t = new BroadcastServerThread(s, list);
				list.add(t);
				t.start();
			}
		}catch (BindException e) { // Exception의 Scope를 고려하지 않으면, 의미없는 서버를 만들 수 있다.
			System.out.println(port + "이미 사용중인 포트입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
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
