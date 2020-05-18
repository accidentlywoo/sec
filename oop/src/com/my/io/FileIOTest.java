package com.my.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest {
	public static void read() {
		String fileName = "a.txt";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			int readValue = -1;
			while((readValue=fis.read()) != -1) {
//				System.out.println(readValue + " : "+ (char)readValue);
				System.out.println("!");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readByChar() {
		String fileName = "a.txt";
		FileReader fr = null;
		try {
			fr = new FileReader(fileName); // 자원과 연결
			int readValue = -1;
			while((readValue=fr.read()) != -1) { // 데이터읽기
				System.out.println(readValue + " : " + (char)readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fr != null) { // NPE 방지
				try {
					fr.close();// 자원과 연결 해제
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		read(); // 한글 깨짐
//		readByChar();
	}
}
