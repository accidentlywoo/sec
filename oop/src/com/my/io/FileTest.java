package com.my.io;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileTest {
	public static void main(String[] args) {
		File f;
		f = new File("C:/수업/oop/a.txt");
		if(f.isFile()) { // if(f.isFile() == true)
			System.out.println("파일 정보입니다.");
			System.out.println("파일 크기 : "+ f.length()); // 파일의 크기\
			System.out.println("쓰기가능여부 : " + f.canWrite());
			System.out.println("파일 최종 수정시간 : "+ new Date(f.lastModified()));
			System.out.println("파일 이름 : " + f.getName());
			System.out.println("경로 : " + f.getPath()); // 상대경로와 절대경로에서 차이가 있다.
		}
		
		File d;
		d = new File("./src/step1"); // == new File(".\\src");
		if(d.isDirectory()) {
			System.out.println("디렉토리 정보입니다.");
			System.out.println(Arrays.toString(d.list())); // 하위 파일, 폴더 명
			String[] listNames = d.list();
			
			File[] listFiles = d.listFiles();
			System.out.println(Arrays.toString(listFiles)); // 하위 폴더의 정보, 파일 정보
			for(File listFile : listFiles) {
				if(listFile.isDirectory()) {
					System.out.println("< " +listFile + " >");
				}else {
					System.out.println(listFile.getName());
				}
			}
		}
	}
}
