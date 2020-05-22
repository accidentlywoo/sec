package com.my.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	public static void main(String[] args) {
		int port; // 1. 포트 할당 변수 생성 : 포트 범위 : 0~65535
		/*
		 * 예약 포트 :  0~1024 : 사용자가 설정하면 안된다.
		 * 사용가능 포트 : 1025~65535
		 */
		 port = 5432;
		 // 2. 서버가 포트를 열어야 한다. 포트를 여는 library는 ServerSocket
		 ServerSocket ss = null;
		 Socket s = null;
		 InputStream is;
		 try {
			ss = new ServerSocket(port);// 포트 열기
			System.out.println("포트 열기 성공"); 
			s= ss.accept(); // Client 접속을 기다린다. Socket객체가 반환
			
			InetAddress clientInfo = s.getInetAddress();
			String clientAddress = clientInfo.getHostAddress();
			System.out.println(clientAddress+"클라이언트가 접속했습니다."); // getHostName() IP
			System.out.println("클라이언트 컴터 이름 : " + clientInfo.getHostName());
			is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String msg = sc.nextLine();
			System.out.println("클라이언트가 보내준 메시지 : " + msg);
		 }catch (BindException e) { // 충분히 일어날 수 있는 Exception은 처리해주자
			System.out.println(port + "이미 사용중인 포트입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(s != null) {
				try {
					s.close(); // Socket을 먼저 닫아야 한다.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.close(); // ServerSocket을 가장 나중에 닫아야 한다.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
