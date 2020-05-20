package com.my.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.my.vo.Customer;

public class ObjectIOTest {
	public static void write() {
		ObjectOutputStream oos = null; // 보조 스트림.
		try {
			oos = new ObjectOutputStream(new FileOutputStream("a.ser",true));
			oos.writeObject(new Date()); // 객체 직렬화
			oos.writeObject("직렬화");
			oos.writeObject(true); // 컴파일시 Auto Boxing :  oos.writeObject(new Boolean(true)); 
			oos.writeObject(new Customer("id1","p1","n1","a1"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos != null) {
				try {
					oos.close(); // 묶어서 close된다.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void read() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("a.ser"));
			for(int i = 0; i < 2; i++) {
				Date dt = (Date)ois.readObject();
				System.out.println(dt); // 현재 시간이 아니고 직렬화할때의 시간을 표시한다.
				String str = (String)ois.readObject();
				System.out.println(str);
				boolean b = (boolean)ois.readObject();
				// 컴파일 단계에서 자동적으로 코드가 변화는 과정
				//Object o = ois.readObject();
				//Boolean bool = (Boolean)o;
				//boolean b = bool.booleanValue();
				System.out.println(b);
				Customer customer = (Customer)ois.readObject();
				System.out.println(customer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
//		write();
//		write();
		read();
	}
}
