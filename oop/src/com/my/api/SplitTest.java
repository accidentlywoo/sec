package com.my.api;

import java.util.Arrays;
import java.util.StringTokenizer;

public class SplitTest {
	public static void main(String[] args) {
//		String strScore = "100:30:70:40";
		String strScore = "100::70:40";
		String[] strSubs = strScore.split(":");
		System.out.println(Arrays.toString(strSubs));
		int total = 0;
		for(String s : strSubs) {
//			if(!s.equals("")) {
//				total+=Integer.parseInt(s);
//			}
			try {
				total+=Integer.parseInt(s);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)(total/strSubs.length));
		
		StringTokenizer st = new StringTokenizer(strScore, ":");
		// tokenizer는 빈문자열 분리를 못한다.
		int cnt = 0;
		total = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			total+= Integer.parseInt(token);
			cnt++;
		}
		System.out.println("tokenizer로 분리하기 total : " + total );
		System.out.println("tokenizer로 분리하기 과목수 :  " + cnt);
		System.out.println("tokenizer로 분리하기 평균 : "+ (float)(total/cnt));
		// Split과 StringTokenizer의 차이가 크다.
	}
}
