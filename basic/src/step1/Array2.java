package step1;

import java.util.Arrays;

public class Array2 {
	public static void main(String[] args) {
		char[][] starArr = new char[5][];
		for(int i = 0; i < 5; i++) {
			starArr[i] = new char[i+1];
		}
		for(int j = 0; j < 5; j++) {
			for(int x = 0; x < starArr[j].length; x ++) {
				starArr[j][x] = '*';
			}
			System.out.println(starArr[j]);
		}
	}
}
