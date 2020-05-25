package com.my.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoServer {
	public static void main(String[] args) {
		int port = 9874;
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			ss = new ServerSocket(port);
			s = ss.accept();
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			while(true) {
				
				String receive = br.readLine();
				if(receive == null) {
					break;
				}
				if(receive.equals("quit")) {
					break;
				}
				bw.write(receive+"\n");
				bw.flush();
			}
		}catch (BindException e) {
			System.out.println(port + "이미 사용중인 포트입니다.");
		}catch (SocketException e) {
			// 반복문이 계속되면서 발생
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br != null) {
				try {
					br.close();
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
