package com.my.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void test(int i) {
		int j = 10;
		//if(i == 0) {
		//	System.out.println("분모는 0이 될 수 없습니다");
		//	return;
		//}
		
		try {
			System.out.println(j/i);//ArithmeticExcetpion
		}catch(ArithmeticException e) {
			System.out.println("분모는 0이 될 수 없습니다");
		}
	}
	
	
	public static void io() {
		FileInputStream fis = null;
		String fileName = "b.txt";//"a.txt";
		try {
			fis = new FileInputStream(fileName); //a.txt자원과 연결
			int readValue = fis.read();
		} catch(IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
//		} catch(FileNotFoundException | IOException e) {
			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
		}finally {
			if(fis != null) {
			try {
				fis.close(); //자원과 연결해제
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
	}
	
	private static int[]arr = new int[5];
	private static int cnt = 0;
//	public static void insertArr(int value) {
//		try {
//			//arr[cnt++] = value;
//			arr[cnt] = value;
//			cnt++;
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("저장소가 꽉찼습니다. 현재cnt=" + cnt);
//		}
//	}
	
	public static void insertArr(int value) throws ArrayIndexOutOfBoundsException{
		try {
			arr[cnt] = value;
			cnt++;			
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("저장소가 꽉찼습니다. 현재cnt=" + cnt);
		}
	}	
	public static void test2() throws ArrayIndexOutOfBoundsException, SQLException{
		System.out.println("----test2()----");
		io();
		
		//for(int i=0; i<10; i++) {
			//try {
			//	insertArr(i);
			//}catch(ArrayIndexOutOfBoundsException e) {
			//	System.out.println(e.getMessage());
			//}
		//}
		
//		try {
//			for(int i=0; i<10; i++) {
//				insertArr(i);
//			}
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
				
		for(int i=0; i<10; i++) {
			insertArr(i);
		}		
		System.out.println("---------------");
		//db처리
		throw new SQLException("DB INSERT실패");
		
		
	}
	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요:");
		Scanner sc;
		sc = new Scanner(System.in);
		try {
			int readValue = sc.nextInt();//java.util.InputMismatchException
			test(readValue);
		}catch(InputMismatchException e) {
			System.out.println("정수를 입력하세요");
		}finally {
			System.out.println("finally...");
		}		
		io();
		//try {
		//	insertArr(9); 	insertArr(-1); insertArr(3);  insertArr(2); insertArr(7);
		//	insertArr(4);
		//}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("저장소가 꽉찼습니다.현재cnt=" + cnt);
		//	System.out.println(e.getMessage());
		//}
		
		try {
			test2();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("END MAIN");
	}
}
