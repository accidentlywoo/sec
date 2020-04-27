package step1;
import java.util.*;

public class Condition2 {
	public static void main(String[] args) {
		// 학점
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
		
		// switch의 표현식()은 byte, short, char, int 타입 String 
		switch(score/10) {
			case 10 :
			case 9 :
				System.out.println("A학점");
				break;
			case 8 :
				System.out.println("B학점");
				break;
			case 7 :
				System.out.println("C학점");
				break;
			case 6 :
				System.out.println("D학점");
				break;
			default :
				System.out.println("F학점");
				break;
		}
		
		Calendar now;
		now = Calendar.getInstance();
		
		int ampm = now.get(java.util.Calendar.AM_PM);
		switch (ampm) {
		case 1:
			System.out.println("오후");
			break;
		default:
			System.out.println("오전");
			break;
		}
		
		
		
		int year;
		/*
		* 년도를 12로 나눈나머지 0부터
		* 원숭, 닭, 개, 돼지, 쥐, 소, 호랭, 퇶, 용, 뱀, 말, 양
		*/
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		year = sc.nextInt();
		int mod = year % 12;
		
		switch(mod) {
			case 0 :
				System.out.println("원숭");
				break;
			case 1 :
				System.out.println("닭");
				break;
			case 2 :
				System.out.println("개");
				break;
		}
	}
}
