package com.my.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class BroadcastClientThread extends Thread {
	private Socket s ;
	private BufferedReader br;
	public BroadcastClientThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	@Override
	public void run() {
		try { // I/O에선 복구 개념이 없기 때문에 try구문을 반복문 바깥쪽에 위치하는 것이 좋다.
			String receive;
			while((receive = br.readLine()) != null) {
			System.out.println(receive);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
}
