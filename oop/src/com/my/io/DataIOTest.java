package com.my.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	public static void writeDataFilter() {
		/*
		 * 1. 목적지("a.dat" 파일);
		 * 2. 노드 스트림(FIleOutputStream)
		 * 3. 필터스트림(DataOutputStream)
		 */
		String fileName = "a.dat"; // 일반 편집기로 읽을 수 없다.
		FileOutputStream fos = null;
		DataOutputStream dos =null;
		try {
			fos = new FileOutputStream(fileName); // a.dat 파일 생성 (없어도 만들고, 있어도 새로 만든다)
			//fos.write(65); 이렇게 날로 쓸 수있지만, 너모 불편하당
			dos = new DataOutputStream(fos); // 보조스트림의 도움을 받아서 편한 사용 쌉 가능
			dos.writeInt(1); // 4bytes
			dos.writeBoolean(true); // 1byte
			dos.writeFloat(3.6F); //4bytes
			dos.writeUTF("A가!"); // 5bytes
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 연결된 자원 중 하나만 close되도 모두 close되지만(?) 안전한 코드를 위해 각각 해야한다.
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void readDataFilter() {
		String fileName = "a.dat";
		/*
		 * 1. 리소스 : a.dat
		 * 2. 노드 스트림 : FileInputStream
		 * 3. 필터 스트림 : DataInputStream
		 */
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			
			System.out.println(dis.readInt());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readFloat());
			System.out.println(dis.readUTF());
			// 순서를 알 수 없으면 출력할 수 없다.
//			int readValue =-1;
//			while((readValue = dis.read()) != -1) {
//				System.out.print(readValue);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		writeDataFilter();
		readDataFilter();
	}
}
