package step1;

import java.util.Arrays;
import java.util.Arrays.*;

public class ArrayCondition {
	public static void main(String[] args) {
//		System.out.println("³âµµ¸¦ ÀÔ·ÂÇÏ½Ã¿À. : ");
//		
//		java.util.Scanner sc;
//		sc = new java.util.Scanner(System.in);
//		
//		int year = sc.nextInt();
//		int mod = year % 12;
//		
//		String[] zodiacSign = new String[] {"¿ø¼şÀÌ", "´ß", "°³", "µÅÁö", "Áã", "¼Ò", "È£¶ûÀÌ", "Åä³¢", "¿ë", "¹ì", "¸»", "¾ç"};
//		System.out.println(zodiacSign[mod]);
		
		int[] lottoArray = new int[6];
		int intCnt = 0;
		while(intCnt < 6) {
			int r = (int)Math.random()*43+1;
			lottoArray[intCnt] = r;
			
			for(int i = 0; i < intCnt; i++) {
				if(lottoArray[intCnt] == lottoArray[i]) {
					intCnt--;
					break;
				}
			}
			intCnt++;
		}
		
		System.out.println(Arrays.toString(lottoArray));
	}
}
