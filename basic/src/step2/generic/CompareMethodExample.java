package step2.generic;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

public class CompareMethodExample {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "���");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "���");
		boolean result1 = GenericMethodUtil.<Integer, String>compare(p1, p1);
		if(result1) {
			System.out.println("�������� ������ ��ü�Դϴ�.");
		}else {
			System.out.println("�������� �������� ���� ��ü�Դϴ�.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "ȫ���");
		Pair<String, String> p4 = new Pair<String, String>("user2", "ȫ���");
		boolean result2 = GenericMethodUtil.compare(p3, p4);
		if(result2) {
			System.out.println("�������� ������ ��ü�Դϴ�.");
		}else {
			System.out.println("�������� �������� ���� ��ü�Դϴ�.");
		}
	}
}
