package step1;
import java.util.Scanner;

public class Loop3 {
	public static void main(String[] args) {
		// 1. �ݾ��� �������� ȯ���Ͻÿ�.
		int money = 1240; // 500�� 2��, 100�� 2�� 10�� 4��
		int change;
		
		// way 2
		change = money;
		if(change != 0) {
			int five = 0;
			int hun = 0;
			int ten = 0;
			int one = 0;
			if(change >= 500) {
				five = change / 500 ;
				change = change % 500;
			}
			if(change >= 100) {
				hun = change / 100;
				change = change % 100;
			}
			if(change >= 10) {
				ten = change / 10;
				change = change % 10;
			}
			
			one = change;
			
			// �ݺ����� �����ʾƵ� �Ǵ� ��쿡 ��������.
			System.out.println("500�� : "+five+", 100�� : "+ hun +", 10�� : "+ten+", 1�� : " + one);
		}
		
		// 2. A, B, C, D, E, F, ~Z ���ĺ��빮�ڸ� ��� ����Ͻÿ�.
		for(int i = 65; i< 91; i++) {
			char a = (char)i;
			System.out.print(a);
		}
		
		char alpha = 'C';
		/*
		 * while(alpha) {
		 * 
		 * }
		 */
			
		
		// 3. 1~10������ ���� �� Ȧ���� ���հ� ¦���� ������ ����Ͻÿ�.
		int odd = 0;
		int even = 0;
		for(int i = 1; i <= 10; i++ ) {
			if(i%2 == 0)
				even+=i;
			else
				odd+=i;
		}
		System.out.println();
		System.out.println("Ȧ�� : "+ odd+", ¦�� : " + even);
		
		// 4. �Է¹��� ���ڰ� �Ҽ��ΰ� �Ǻ��Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
	
		System.out.println("�Ҽ� ������ ���ڸ� �Է��ϼ���");
		int s = sc.nextInt();
		if(s < 2)
			System.out.println("�Է��� \"+s+\"�� �Ҽ��� �ƴմϴ�");
		for(int i = 2; i < s; i++) {
			if(s / i  > 0)
				flag = false;
		}
		if(flag)
			System.out.println("�Է��� "+s+"�� �Ҽ��Դϴ�.");
		else
			System.out.println("�Է��� "+s+"�� �Ҽ��� �ƴմϴ�.");
	}
}
