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
		// Ȧ�� 1���� 10�� ���
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
		
		System.out.println("---------�Ǻ���ġ ����----------");
		iCnt = 0; //�ݺ� Ƚ��
		maxCnt = 10; // 10ȸ �ݺ�
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
		
		// 1~45������ 6���� ������ ���ڸ� ����Ͻÿ�.
		
		int r = 0;
		int ranNum;
		int ranCnt = 6;
		
		System.out.println("---------���� ��----------");
		while(r < ranCnt) {
			ranNum = (int)(Math.random()*45)+1;
			System.out.println(ranNum);
			r++;
		}
		
		System.out.println("---------���� ��----------");
		int dan = 2;
		while(dan <= 15) {
			i = 1;
			System.out.print(dan + "�� : ");
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
		// break�� while�� �� scope Ż���ϱ�
//		
//		System.out.println("---------���� ���� ��----------");
//		dan = 2;
//		while(dan <= 15) {
//			i = 1;
//			System.out.print(dan + "�� : ");
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
//		// return ���� �׳� �� �ȵǴ� ��ü Ż��
		
		System.out.println("---------�� ���� ��----------");
		dan = 2;
		a : while(dan <= 15) {
			i = 1;
			System.out.print(dan + "�� : ");
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
