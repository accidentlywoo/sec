package step1;

public class Loop {
	public static void main(String[] args) {
		int cnt = 5;
		int i = 1;
//		while ( i <= cnt) {
//			System.out.println("h1 " +i);
//			i++;
//		}
		while(i <= cnt) {
			System.out.println(i);
			i++;
			//System.out.println(i++);;
		}
		
		System.out.println("-------------------");
		int j = 0;
		while(j < cnt) {
			System.out.println(++j);
		}
		
		System.out.println("-------------------");
		// 홀수 1부터 10개 찍기
		int s = 0;
		while(s < 10) {
			System.out.println(1+2*s);
			s++;
		}
		
		System.out.println("-------------------");
		i = 1;
		int maxCnt = 10;
		int iCnt = 0;
		while(iCnt < maxCnt) {
			if(i%3 != 0)
				System.out.println(i);
			
			i += 2;
			iCnt++;
		}
		
		System.out.println("---------피보나치 수열----------");
		iCnt = 0; //반복 횟수
		maxCnt = 10; // 10회 반복
		int b2 = 0;
		int b = 1;
		
		System.out.println(1);
		while(iCnt < maxCnt) {
			int current = b2 + b;
			System.out.println(current);
			b2 = b;
			b = current;
			iCnt++;
		}
		
		// 1~45사이의 6개의 임의의 숫자를 출력하시오.
		
		int r = 0;
		int ranNum;
		int ranCnt = 6;
		
		System.out.println("---------랜덤 픽----------");
		while(r < ranCnt) {
			ranNum = (int)(Math.random()*45)+1;
			System.out.println(ranNum);
			r++;
		}
		
		System.out.println("---------구구 단----------");
		int dan = 2;
		while(dan <= 15) {
			i = 1;
			System.out.print(dan + "단 : ");
			while(i <= 9) {
				if(i != 1)
					System.out.print(", ");
				int result = dan * i;
				if(result > 100)
					break;
				System.out.print(result);
				i++;
			}
			System.out.println();
			dan++;
		}
		// break로 while문 한 scope 탈출하기
//		
//		System.out.println("---------리턴 구구 단----------");
//		dan = 2;
//		while(dan <= 15) {
//			i = 1;
//			System.out.print(dan + "단 : ");
//			while(i <= 9) {
//				if(i != 1)
//					System.out.print(", ");
//				int result = dan * i;
//				if(result > 100)
//					return;
//				System.out.print(result);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
//		// return 으로 그냥 다 안되누 전체 탈출
		
		System.out.println("---------라벨 구구 단----------");
		dan = 2;
		a : while(dan <= 15) {
			i = 1;
			System.out.print(dan + "단 : ");
			b : while(i <= 9) {
				if(i != 1)
					System.out.print(", ");
				int result = dan * i;
				if(result > 100)
					break a;;
				System.out.print(result);
				i++;
			}
			System.out.println();
			dan++;
		}
	}
}
