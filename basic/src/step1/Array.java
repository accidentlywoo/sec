package step1;

import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
//		int[] scoreArr; // int scoreArr[]; �迭 ����
//		scoreArr = new int[3]; // �迭 ���� 
		int[] scoreArr = new int[3];
		
		System.out.println(scoreArr[0]);
		scoreArr[0] = 45; // ��������
		scoreArr[1] = 70; //����
		scoreArr[2] = 80; //����
//		scoreArr[-1] = 100; java.lang.ArrayIndexOutOfBoundsException
//		scoreArr[3] = 90; java.lang.ArrayIndexOutOfBoundsException
		int size = scoreArr.length;
		int totalScore = 0;
		for(int i = 0; i < size; i ++) {
			totalScore+=scoreArr[i];
		}
		System.out.println(totalScore);
		
		// �迭 �ʱ�ȭ
		int[] maxArr = {31, 28, 31, 30};
		
		System.out.println(maxArr.length);
		System.out.println(maxArr[0]);
		
		int index = 1;
		maxArr[index] = 29;
		
		System.out.println(maxArr[index]);
		
		int[] numArr = {1, 3, 10, 2, 3, 5, 8, 10, 2};
		int[] cntArr = new int[10];
		
		/*
		 *  ���� 1�� ���� Ƚ���� cntArr[0]�� ����
		 *  ���� 2�� ���� Ƚ���� cntArr[1]�� ����
		 *  ...
		 *  ���� 10�� ���� Ƚ���� cntArr[9]�� ����
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
		// �迭�� ���ʱ�ȭ
		cntArr = new int[10];
		
		for(int z = 0; z < numLeng; z++) {
			cntArr[numArr[z] - 1]++;
		}
		System.out.println(Arrays.toString(cntArr));
		
		// �迭�� �ִ� ���ϱ�
		numArr = new int[] {1, 5, 3, 4, 2}; // �迭 ���ʱ�ȭ
		int maxNum = 0; // �ִ�
		int numLen2 = numArr.length;
		
		for(int x = 0; x < numLen2; x++) {
			if(numArr[x] > maxNum) {
				maxNum = numArr[x];
			}
		}
		System.out.println(maxNum);
	}
} 
