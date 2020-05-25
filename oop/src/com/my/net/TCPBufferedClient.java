package com.my.net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPBufferedClient {
	public static void main(String[] args) {
		int port = 6543;
		String serverIp = "192.168.0.115";
		Socket s = null;
		OutputStream os = null;
		BufferedWriter bw = null;
//		Scanner sc = null;
		try {
			s = new Socket(serverIp, port);
			os = s.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write("1 \n"); bw.flush();
			bw.write("2 \n"); bw.flush();
			bw.write("3 \n"); bw.flush();
			bw.write("quit \n"); bw.flush();
//			String msg;
//			do {
//				System.out.println("서버로 보낼 메시지를 입력하세요. 종료하려면 quit을 입력하세요.");
//				msg = sc.nextLine();
//				bw.append(msg);
//				bw.flush();
//			}while(msg.equals("quit"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
