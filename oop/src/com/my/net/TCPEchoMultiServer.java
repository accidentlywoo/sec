package com.my.net;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoMultiServer {
	public static void main(String[] args) {
		int port = 9874;
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(port);
			while(true) {
				s = ss.accept();
				System.out.println("접속했습니다.");
				new EchoServerThread(s).start();
			}
		}catch (BindException e) { // Exception의 Scope를 고려하지 않으면, 의미없는 서버를 만들 수 있다.
			System.out.println(port + "이미 사용중인 포트입니다.");
		}catch (SocketException e) {
			// 반복문이 계속되면서 발생
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
