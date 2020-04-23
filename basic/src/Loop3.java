import java.util.Scanner;

public class Loop3 {
	public static void main(String[] args) {
		// 1. 금액을 동전으로 환전하시오.
		int money = 1240; // 500원 2개, 100원 2개 10원 4개
		int change;
//		int fiveT = money/500;
//		change = money - (500 * fiveT);
//		int oneH = change/100;
//		change = change - (100 * oneH);
//		int ten = change/10;
//		change = change - (10 * ten);
//		int one = 0;
//		if(change != 0) 
//			one = change;
		
		// way 2
		change = money;
		if(change != 0) {
			int five = 0;
			int hun = 0;
			int ten = 0;
			int one = 0;
			while(change >= 500) {
				change = change - 500;
				five++;
			}
			while(change >= 100) {
				change = change - 100;
				hun++;
			}
			while(change >= 10) {
				change = change - 10;
				ten++;
			}
			while(change >= 1) {
				change = change - 1;
				one++;
			}
			System.out.println("500원 : "+five+", 100원 : "+ hun +", 10원 : "+ten+", 1원 : " + one);
		}
		
		// 2. A, B, C, D, E, F, ~Z 알파벳대문자를 모두 출력하시오.
		for(int i = 65; i< 91; i++) {
			char a = (char)i;
			System.out.print(a);
		}
			
		
		// 3. 1~10사이의 숫자 중 홀수의 총합과 짝수의 총합을 출력하시오.
		int odd = 0;
		int even = 0;
		for(int i = 1; i <= 10; i++ ) {
			if(i%2 == 0)
				even+=i;
			else
				odd+=i;
		}
		System.out.println();
		System.out.println("홀수 : "+ odd+", 짝수 : " + even);
		
		// 4. 입력받은 숫자가 소수인가 판별하시오.
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
	
		System.out.println("소수 구분할 숫자를 입력하세요");
		int s = sc.nextInt();
		
		for(int i = 2; i < s; i++) {
			if(s / i  > 0)
				flag = false;
		}
		if(flag)
			System.out.println("입력한 "+s+"는 소수입니다.");
		else
			System.out.println("입력한 "+s+"는 소수가 아닙니다.");
	}
}
