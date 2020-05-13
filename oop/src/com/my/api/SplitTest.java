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
		
		//https://post.naver.com/viewer/postView.nhn?volumeNo=28238156&memberNo=43457750
		/*
		 * URL 구조
		 * scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]
		 *  - scheme : 프로토콜
		 *  - host : 호스트 명
		 *  - path : 패스
		 *  - query : 쿼리이름
		 */
		String url = "https://post.naver.com/viewer/postView.nhn?volumeNo=28238156&memberNo=43457750";
		String protocol = "";
		String hostname = "";
		String[] path;
		String[] querys;
//		String[] questionSplit = url.split("?"); // regex에대한 Exception이 발생한다.
//		String[] questionSplit = url.split("[?]");
		String[] questionSplit = url.split("\\?");
		
		String protocolNhostnameNpath = questionSplit[0];
		String querysN = questionSplit[1];
		protocol = protocolNhostnameNpath.split("://")[0];
		System.out.println("------- URL Split --------");
		System.out.println("url : " + url);
		
		System.out.println("protocol : " + protocol);
		String hostnameNpath = protocolNhostnameNpath.split("://")[1];
		hostname = hostnameNpath.split("/")[0];
		System.out.println("hostname : " + hostname);
		int pathLen = hostnameNpath.split("/").length;
		path = new String[pathLen];
		for(int i = 1; i < pathLen; i++) {
			path[i-1] = hostnameNpath.split("/")[i];
			System.out.println("paths no."+i+" : " + path[i-1]);
		}
		
		int queryLen = querysN.split("&").length;
		querys = new String[queryLen];
		for(int i = 0; i < queryLen; i++) {
			querys[i] = querysN.split("&")[i];
			int eqIndex = querys[i].indexOf("=");
			// indexOf : C부터 제공하는 클뤠식한 메소드 찾는 문자없으면 -1반환.. ㄷㄷ
			System.out.println("query name : "+ querys[i].substring(0, eqIndex));
			System.out.println("query value : " + querys[i].substring(eqIndex+1));
//			System.out.println("query value : " + querys[i].substring(eqIndex+1, querys[i].length()));
		}
		
		String fileName = "a.txt";
//		fileName.endsWith(".txt"); // 파일 확장자 체크할 때 많이 사용.
		if(fileName.endsWith(".txt")) {
			System.out.println("텍스트 파일 형식 입니다.");
		}else if(fileName.endsWith(".exe")) {
			System.out.println("실행 파일 입니다.");
		}
	}
}
