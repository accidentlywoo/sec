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
		//	System.out.println("�и�� 0�� �� �� �����ϴ�");
		//	return;
		//}
		
		try {
			System.out.println(j/i);//ArithmeticExcetpion
		}catch(ArithmeticException e) {
			System.out.println("�и�� 0�� �� �� �����ϴ�");
		}
	}
	
	
	public static void io() {
		FileInputStream fis = null;
		String fileName = "b.txt";//"a.txt";
		try {
			fis = new FileInputStream(fileName); //a.txt�ڿ��� ����
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
				fis.close(); //�ڿ��� ��������
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
//			System.out.println("����Ұ� ��á���ϴ�. ����cnt=" + cnt);
//		}
//	}
	
	public static void insertArr(int value) throws ArrayIndexOutOfBoundsException{
		try {
			arr[cnt] = value;
			cnt++;			
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("����Ұ� ��á���ϴ�. ����cnt=" + cnt);
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
		//dbó��
		throw new SQLException("DB INSERT����");
		
		
	}
	public static void main(String[] args) {
		System.out.print("���ڸ� �Է��ϼ���:");
		Scanner sc;
		sc = new Scanner(System.in);
		try {
			int readValue = sc.nextInt();//java.util.InputMismatchException
			test(readValue);
		}catch(InputMismatchException e) {
			System.out.println("������ �Է��ϼ���");
		}finally {
			System.out.println("finally...");
		}		
		io();
		//try {
		//	insertArr(9); 	insertArr(-1); insertArr(3);  insertArr(2); insertArr(7);
		//	insertArr(4);
		//}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("����Ұ� ��á���ϴ�.����cnt=" + cnt);
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
