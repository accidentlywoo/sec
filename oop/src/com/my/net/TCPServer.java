package com.my.net;

import java.io.IOException;
import java.net.ServerSocket;

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
		 ServerSocket sA = null;
		 try {
			ss = new ServerSocket(port);// 포트 열기
			sA = new ServerSocket(port);//java.net.BindException
			/*
			 * 같은 Transport [TCP/UDP]에서 같은 포트를 뚫으면 BindException발생
			 * UDP로 같은 포트쓰면 익셉션 안난다.
			 */
			System.out.println("포트 열기 성공"); 
			ss.accept();
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
