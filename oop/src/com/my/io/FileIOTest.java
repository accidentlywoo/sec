package com.my.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

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
	
	public static void write() {
		String fileName = "a.txt";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			
			InputStream is = System.in; // 키보드로 입력한 값
			
			int readValue = -1;
			while((readValue = is.read()) != -1) { // window : ctrl + z ==-1 / linux : ctrl + c == -1
				fos.write(readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void writeByChar() {
		String fileName = "a.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			for(int i = 0; i < 10; i++) {
				fw.write(44032+i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
//		read(); // 한글 깨짐
//		readByChar(); // 한글 깨지지 않음
		write(); // 한 깽 - 키보드로 입력받은 값을 a.txt에 출력
//		readByChar();
//		writeByChar(); // 한 안 깽
	}
}
