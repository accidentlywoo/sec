package com.my.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class BroadcastServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private String clientAddres;
	private List<BroadcastServerThread>list;
	
	private String receive() throws IOException {
		return br.readLine();
	}
	private void send(String sendMsg) throws IOException {
		bw.write(sendMsg+"\n");
		bw.flush();
	}
	private void broadcast(String sendMsg){
		for(BroadcastServerThread item : list) {
			try {
				item.send(sendMsg);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() { // Thread run()에서 throws가 없기때문에, throws사용불가. 메소드 overriding 규칙췤
		try {
			String sendMsg = clientAddres + "가 접속했습니다.";
			broadcast(sendMsg);
			String receive;
			while((receive =receive()) != null) {
				if(receive.equals("quit")) {
					break;
				}
				broadcast(clientAddres +" > : "+receive +"\n");
			}
		}catch (NullPointerException e) { // br.readLine() 클라이언트가 강제 연결끊을경우
			e.printStackTrace();
		}catch (SocketException e) {
			// 반복문이 계속되면서 발생 / 클라이언트 연결이 끊겼을 때.
		}catch (IOException e) {
			e.printStackTrace();
		}finally { // 한 Client의 대응에서 발생할 수 있는 Exception은 안쪽으로 빼놓자.
			String sendMsg = clientAddres + "가 접속 해제했습니다.";
			broadcast(sendMsg);
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
			list.remove(this);// 현재 객체를 list에서 제거하기
		}
	}
	
	public BroadcastServerThread(Socket s) throws IOException {
		this(s, null);
	}
	public BroadcastServerThread(Socket s, List<BroadcastServerThread> list) throws IOException {
		this.list = list;
		this.s = s;
		clientAddres  = this.s.getInetAddress().getHostName();
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	}

	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
}
