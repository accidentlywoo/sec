package step1;

import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
//		int[] scoreArr; // int scoreArr[]; 배열 선언
//		scoreArr = new int[3]; // 배열 생성 
		int[] scoreArr = new int[3];
		
		System.out.println(scoreArr[0]);
		scoreArr[0] = 45; // 국어점수
		scoreArr[1] = 70; //수학
		scoreArr[2] = 80; //영어
//		scoreArr[-1] = 100; java.lang.ArrayIndexOutOfBoundsException
//		scoreArr[3] = 90; java.lang.ArrayIndexOutOfBoundsException
		int size = scoreArr.length;
		int totalScore = 0;
		for(int i = 0; i < size; i ++) {
			totalScore+=scoreArr[i];
		}
		System.out.println(totalScore);
		
		// 배열 초기화
		int[] maxArr = {31, 28, 31, 30};
		
		System.out.println(maxArr.length);
		System.out.println(maxArr[0]);
		
		int index = 1;
		maxArr[index] = 29;
		
		System.out.println(maxArr[index]);
		
		int[] numArr = {1, 3, 10, 2, 3, 5, 8, 10, 2};
		int[] cntArr = new int[10];
		
		/*
		 *  숫자 1의 출현 횟수는 cntArr[0]에 저장
		 *  숫자 2의 출현 횟수는 cntArr[1]에 저장
		 *  ...
		 *  숫자 10의 출현 횟수는 cntArr[9]에 저장
		 */
		int numLeng = numArr.length;
		int countMax = 10;
		
		for(int i = 0; i < numLeng; i++) {
			for(int j = 1; j <= countMax; j++) {
				if(numArr[i] == j) {
					cntArr[j-1]++;
				}
			}
		}
		System.out.println(Arrays.toString(cntArr));
		//int[] cntArr2 = new int[10];
		// 배열의 재초기화
		cntArr = new int[10];
		
		for(int z = 0; z < numLeng; z++) {
			cntArr[numArr[z] - 1]++;
		}
		System.out.println(Arrays.toString(cntArr));
		
		// 배열의 최댓값 구하기
		numArr = new int[] {1, 5, 3, 4, 2}; // 배열 재초기화
		int maxNum = 0; // 최댓값
		int numLen2 = numArr.length;
		
		for(int x = 0; x < numLen2; x++) {
			if(numArr[x] > maxNum) {
				maxNum = numArr[x];
			}
		}
		System.out.println(maxNum);
	}
} 
