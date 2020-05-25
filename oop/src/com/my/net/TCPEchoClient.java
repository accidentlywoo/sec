package com.my.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {
	public static void main(String[] args) {
		int port = 9876;
		String serverIp = "192.168.0.118";
		Socket s = null;
		OutputStream os = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			
			s = new Socket(serverIp, port);
			os = s.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			bw.write("wid1:p1:n1:a1\n");
			bw.flush();
			System.out.println(br.readLine());
			
			bw.write("!!!!wid2:p2:n2:a2\n");
			bw.flush();
			System.out.println(br.readLine());
			
			bw.write("wid3:p3:n3:a3\n");
			bw.flush();
			System.out.println(br.readLine());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (ConnectException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
