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
			while(true) {
				s = ss.accept();
				try {
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					
					while(true) {
						String receive = br.readLine();
						
						if(receive.equals("quit")) {
							break;
						}
						bw.write(receive+"\n");
						bw.flush();
					}
				}catch (NullPointerException e) { // br.readLine() 클라이언트가 강제 연결끊을경우
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}finally { // 한 Client의 대응에서 발생할 수 있는 Exception은 안쪽으로 빼놓자.
					System.out.println(s.getPort()+"클라이언트와 접속 해제했습니다.");
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
				}
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
