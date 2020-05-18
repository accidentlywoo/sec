package com.my.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardTest {
	public static void main(String[] args) {
		InputStream is = System.in;
		try {
			int readValue = is.read(); // Enter누를때까지 기둘
			System.out.println(readValue + " : "+(char)readValue);
			// byte 단위로 읽기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
