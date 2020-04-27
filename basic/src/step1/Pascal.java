package step1;

import java.util.Arrays;

public class Pascal {
	public static void main(String[] args) {
		// 8´Ü ÆÄ½ºÄ® »ï°¢Çü
		int[][] pArr = new int[8][];
		int pArrLen = pArr.length;
		
		for(int i = 0; i < pArrLen; i ++) {
			pArr[i] = new int[i+1];
		}
		
		for(int row = 0; row < pArrLen; row++) {
			int pArrRowLen = pArr[row].length;
			for(int col = 0; col <pArrRowLen; col ++) {
				if(col == 0) {
					pArr[row][0] = 1;
				}else if(col == pArrRowLen-1) {
					pArr[row][pArrRowLen-1]=1;
				}else {
					pArr[row][col] = pArr[row-1][col-1]+pArr[row-1][col];
				}
			}
			for(int z = 0; z < pArrLen-row; z++) {
				System.out.print("  ");
			}
			System.out.println(Arrays.toString(pArr[row]));
		}
	}
}
