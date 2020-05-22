package com.my.net;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) {
		// 서버 ip와 서버 port를 알고 있어야 한다.
		int port = 5432;
//		String serverIP = "192.168.0.110";
		String serverIP = "192.168.0.115"; // localhost
//		String serverIP ="127.0.0.1"; //localhost 인터넷 연결없이도 루프빽 포트로 사용쌉 가능
		Socket s = null;
		try {
			s = new Socket(serverIP, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
			System.out.println("ConnectException : 서버가 구동되었는지 확인하세요. ");
			System.out.println("PORT가 정확한지 확인하세요.");
			System.out.println("IP가 정확한지 확인하세요.");
			//: 항상 처리해줘야 한다. 다양한 클라이언트 오류에 대해 대응할 준비를 해야한다.
			// server 뒤짐 / port잘못됨 / ip잘못됨
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
		}
	}
}
