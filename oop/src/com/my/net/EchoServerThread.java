package com.my.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	@Override
	public void run() { // Thread run()에서 throws가 없기때문에, throws사용불가. 메소드 overriding 규칙췤
		try {
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
		}catch (IOException e) {
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
	
	public EchoServerThread(Socket s) throws IOException {
		this.s = s;
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
