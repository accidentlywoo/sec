package com.my.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPBufferedClient {
	public static void main(String[] args) {
		int port = 6543;
		String serverIp = "192.168.0.118";
		Socket s = null;
		DataOutputStream dos = null;
		try {
			s = new Socket(serverIp, port);
			dos = new DataOutputStream(s.getOutputStream());
			for(int i = 0; i < 10; i++) {
				dos.writeInt(i);
				dos.writeBoolean(i%2 == 0 ? true : false);
				dos.writeUTF("테스트" + i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
