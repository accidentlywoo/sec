package com.my.net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPBroadcastClient {
	public static void main(String[] args) {
		int port = 1234;
		String serverIp = "192.168.0.115";
		Socket s = null;
		OutputStream os = null;
		BufferedWriter bw = null;
//		BufferedReader br = null;
		Scanner sc = null;
		try {
			s = new Socket(serverIp, port);
			os = s.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
//			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			sc = new Scanner(System.in);
			
			BroadcastClientThread broadcastClientThread = new BroadcastClientThread(s);
			broadcastClientThread.start();
			
			while(true) {
				System.out.println("메시지를 입력하세요. : ");
				String receive = sc.nextLine()+"\n";
				bw.write(receive);
				bw.flush();
				if(receive.equals("quit")) {
					break;
				}
//				System.out.println(br.readLine());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) { // 연결되지 않을때
			System.out.println();
		} catch(SocketException e) { // 연결은됬으나 상대쪽에서 연결을 끊었을때.
			System.out.println("서버와의 연결이 끊겼습니다.");
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
