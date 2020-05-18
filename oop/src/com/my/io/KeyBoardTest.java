package com.my.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class KeyBoardTest {
	public static void main(String[] args) {
		InputStream is = System.in;
		Reader r =  new InputStreamReader(is);
		try {
			int readValue = r.read(); //char 일기
			System.out.println(readValue + " : " + (char)readValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
