package com.my.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class KeyBoardTest {
	public static void main(String[] args) {
		InputStream is = System.in;
		Reader r =  new InputStreamReader(is);
		byte[] bytes = new byte[100];
		try {
			int readCnt = is.read(bytes);
			System.out.println("읽어온 바이트 수 : " + readCnt);
			for(int i = 0; i < readCnt; i ++) {
				System.out.println(bytes[i] + " : " + (char)bytes[i]);
			}
		}catch (IOException e) {
		}
		
	}
}
