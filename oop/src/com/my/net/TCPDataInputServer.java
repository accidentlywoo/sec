package com.my.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPDataInputServer {
	public static void main(String[] args) {
		int port = 6543;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		try {
			ss = new ServerSocket(port);
			s = ss.accept();
			
			
			dis = new DataInputStream(s.getInputStream());
			
			while(true) {
				int receiveInt = dis.readInt();
				boolean receiveBool = dis.readBoolean();
				String receiveUTF = dis.readUTF();
				System.out.println("클라이언트가 보낸 메세지 : " + receiveInt+", "+ receiveBool +", " +receiveUTF);
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
