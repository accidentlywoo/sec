package step1;
import java.util.*;

public class Condition2 {
	public static void main(String[] args) {
		// ����
		int score  = 2;
		if(score > 90)
			System.out.println("A");
		else if(score >= 80)
			System.out.println("B");
		else if(score >= 70)
			System.out.println("C");
		else if(score >= 60)
			System.out.println("D");
		else
			System.out.println("F");
		
		// switch�� ǥ����()�� byte, short, char, int Ÿ�� String 
		switch(score/10) {
			case 10 :
			case 9 :
				System.out.println("A����");
				break;
			case 8 :
				System.out.println("B����");
				break;
			case 7 :
				System.out.println("C����");
				break;
			case 6 :
				System.out.println("D����");
				break;
			default :
				System.out.println("F����");
				break;
		}
		
		Calendar now;
		now = Calendar.getInstance();
		
		int ampm = now.get(java.util.Calendar.AM_PM);
		switch (ampm) {
		case 1:
			System.out.println("����");
			break;
		default:
			System.out.println("����");
			break;
		}
		
		
		
		int year;
		/*
		* �⵵�� 12�� ���������� 0����
		* ����, ��, ��, ����, ��, ��, ȣ��, �k, ��, ��, ��, ��
		*/
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		year = sc.nextInt();
		int mod = year % 12;
		
		switch(mod) {
			case 0 :
				System.out.println("����");
				break;
			case 1 :
				System.out.println("��");
				break;
			case 2 :
				System.out.println("��");
				break;
		}
	}
}
