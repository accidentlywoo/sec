package com.my.net;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class TCPBroadcastMultiServer {
	public static void main(String[] args) {
		int port = 1234;
		ServerSocket ss = null;
		Socket s = null;
		// ArrayList는 Thread Safe 한가? 
		// -> 자료구조에서 이미 구현되있고, 최적화된 자료구조를 사용하자
		// 변수의 자료형은 구체화된 클래스형태를 사용하지말고 일반화된 형태를 사용하자
		// ex) ArrayList<~> X -> List<~>
		List<BroadcastServerThread> list = new Vector<>();
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
