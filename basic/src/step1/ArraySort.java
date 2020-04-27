package step1;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		int[] numArr = {5, 3, 8, 5, 1, 2, 7};
		// 선택 정렬 구현하기
		int numLen = numArr.length;
		
		for(int index = 0; index < numLen; index++) {
			int min = index;
			
			for(int scan = index+1; scan < numLen ; scan++) {
				if(numArr[scan] < numArr[min]) {
					min = scan;
				}
			}
			
			int temp = numArr[min];
			numArr[min] = numArr[index];
			numArr[index] = temp;
		}
		
		System.out.println(Arrays.toString(numArr));
		
		// 버블 정렬 구현하기
		numArr = new int[]{5, 3, 8, 5, 1, 2, 7};
		for(int index = 0; index < numLen; index++) {
			for(int scan = 0; scan < numLen-index-1; scan++) {
				if(numArr[scan] > numArr[scan+1]) {
					int temp = numArr[scan];
					numArr[scan] = numArr[scan+1];
					numArr[scan+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numArr));
	}
}
