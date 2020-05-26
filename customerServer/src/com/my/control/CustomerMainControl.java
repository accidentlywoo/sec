package com.my.control;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Vector;

public class CustomerMainControl {
	public static void main(String[] args) {
		int port = 1234;
		ServerSocket serverSocket = null;
		Socket socket = null;
		List<CustomerBufferedControl> controls = new Vector<CustomerBufferedControl>();
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				socket = serverSocket.accept();
				
				CustomerBufferedControl control = new CustomerBufferedControl(socket, controls);
				controls.add(control);
				control.start();
			}
		}catch (BindException e) {
			System.out.println(port+" : 이미 사용중인 포트입니다.");
		}catch (SocketException e) {
			System.out.println("Socket이 비 정상적으로 끊겼습니다.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
