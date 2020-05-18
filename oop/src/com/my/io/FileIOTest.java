package com.my.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
				fos.write(readValue); // is.read()  1byte를 읽고 쓰고 읽고쓰고 조합조합~
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
//			for(int i = 0; i < 10; i++) {
//				fw.write(44032+i);
//			}
			InputStream is = System.in;
			InputStreamReader r = new InputStreamReader(is);
			int readValue = -1;
			while((readValue = r.read()) != -1) {
				fw.write(readValue);
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
	public static void copyNpastByte() {
//		String fileName = "춘추꽃.png"; 
//		String copyFileName = "춘추꽃copy.png";
		String fileName; 
		String copyFileName;
		Scanner sc = new Scanner(System.in);
		System.out.println("원본파일(복사 대상)의 이름을 입력하세요. : ");
		fileName = sc.nextLine();
		
		System.out.println("대상파일(복사 된)의 이름을 입력하세요. : ");
		copyFileName = sc.nextLine();
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream(copyFileName);
			
			int readValue = -1;
//			while((readValue = fis.read()) != -1) {
//				fos.write(readValue);
//			}
			byte[] bytes = new byte[1024];
			while((readValue = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, readValue);
			}
		}catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(fis != null) {
					fis.close(); // 파일 close는 개별적으로 해줘야 한다. 
				}
				if(fos != null) {
					fos.close(); // xxxx Bad Code
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void copyNpastTxt() {
		String fileName = "a.txt";
		String copyFileName = "b.txt";
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(copyFileName);
			
			fr = new FileReader(fileName);
			int readValue = -1;
			while((readValue = fr.read()) != -1) {
				fw.write(readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
//		readByChar(); // 한글 깨 지지 않음
//		write(); // 한 깽 - 키보드로 입력받은 값을 a.txt에 출력
//		readByChar();
//		writeByChar(); // 한 안 깽
//		copyNpastTxt(); // a.txt 파일을 복사하여 b.txt에 붙여넣기
		copyNpastByte();
	}
}
