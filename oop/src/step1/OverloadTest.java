package step1;

import java.util.Scanner;

public class OverloadTest {
/*
 * 		Overload ����
 * 		1. �޼��� �̸� ����
 * 		2. �Ű����� Ÿ�� �Ǵ� ���� �Ǵ� ������ ��0��
 */
	public static void add(int a, int b) {System.out.println(a+b);}
	public static void add(float a, float b) {System.out.println(a+b);}
	public static void add(int a, int b, float c) {System.out.println(a+b+c);}
	public static void add(float a, int b, int c) {System.out.println(a+b+c);}
	
	//public static void add(int c, int d) {System.out.println(c+d);} �޼��� �ߺ� - ������ �������
	//public int void add(int c, int d) {System.out.println(c+d);} �޼��� �ߺ� - return type �������
	
	public static void main(String[] args) {
		byte b1, b2;
		b1 = 10;
		b2 = 20;
		add(b1, b2); // int Ÿ������ �ڵ� ����ȯ
		
		char c1, c2;
		c1 = 'A';
		c2 = 'B';
		add(c1, c2); // int Ÿ������ �ڵ� ����ȯ
		
		long lo1, lo2;
		lo1 = 1L;
		lo2 = 2L;
		add(lo1, lo2); // float Ÿ���� Long Ÿ�Ժ��� ũ�Ⱑ ũ��.

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		if(N % 2 == 1){
			System.out.println("Weird");
		}
		else{
			if(N <= 5)
				System.out.println("Weird");
			else if( N <= 20)
				System.out.println("Weird");
			else
				System.out.println("Not Weird");
		}
		scanner.close();
	}
}
