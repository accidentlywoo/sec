package com.my.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintFTest {
	public static void main(String[] args) {
		PrintStream ps = System.out; // 자원과 직접만나는 스트림이 아니다. : 보조 스트림
		File s = new File("1");
		try {
			FileOutputStream fos = new FileOutputStream(s); // 자원과 직접 만나는 스트림 : 노드 스트림
			PrintStream ps2 = new PrintStream(fos); // 필터 스트림 : 보조 스트림 DataInputStream / DataOutputStream
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ps.printf("%10d|%-10d\n", 123, 123);
		ps.printf("%10.2f|%-10.2f", 123.4, 123.4);
		ps.printf("|%10.2f|%-10.2f", 123.456, 123.456);
		ps.printf("\n%3s", "hello");
		ps.printf("\n%c\n",'*');
		
		String star = "*";
		for(int i = 1; i <= 5; i++) {
			ps.printf("\n%6s", star);	
			star+="*";
		}
		
	}
}
