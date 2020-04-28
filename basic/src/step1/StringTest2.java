package step1;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		String pStr ="ABCDCBA"; //팰린드롬 문자열 앞 뒤로 읽는 내용이 똑같음. 토마토 ABBA
		System.out.println(pStr.charAt(2));
		int size = pStr.length();
		System.out.println(size);
		// 1) 문자열의 중간위치 계산
		int midPoint = size/2; // 반복문의 조건에서 연산을 사용하면 반복효율이 좋지 않다.
		// 2) 첫번째 문자 pStr.charArt(0) 값과 마지막 문자
		boolean flag = true;
		for(int i = 0; i < midPoint; i ++) {
			if(pStr.charAt(i) != pStr.charAt(size-(i+1))) {
				flag = false;
			}
		}
		if(flag)
			System.out.println("팰린드롬 문자열입니다.");
		else
			System.out.println("팰린드롬 문자열이 아닙니다.");
		
		Scanner sc;
		sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.println("문자열을 입력하세요.  (add : 추가 작업, retrieve : 조회 작업, modify : 수정 작업, quit : 종료 작업)) : ");
//			String line = sc.nextLine();
//			
//			if(line.equalsIgnoreCase("quit")) {
//				System.out.println("작업을 종료하겠습니다.");
//				break;
//			}else if(line.equalsIgnoreCase("add")) {
//				System.out.println(" 추가 작업을 선택하셨습니다. ");
//				System.out.println("아이디 : ");
//				String id = sc.nextLine();
//				
//				System.out.println("비밀번호 : ");
//				String pwd = sc.nextLine();
//				
//				System.out.println("이름 : ");
//				String name = sc.nextLine();
//				
//				System.out.println("주소 : ");
//				String address = sc.nextLine();
//				
//				System.out.println(id +", "+ pwd +", "+ name +", "+ address);
//			}else if(line.equalsIgnoreCase("retrieve")) {
//				System.out.println(" 조회작업을 선택하셨습니다. ");
//			}else if(line.equalsIgnoreCase("modify")) {
//				System.out.println("수정작업을 선택하셨습니다.");
//			}else {
//				System.out.println("그외의 작업을 선택하셨습니다.");
//			}
//		}
		while(true) {
			System.out.println("문자열을 입력하세요.  (add : 추가 작업, retrieve : 조회 작업, modify : 수정 작업, quit : 종료 작업)) : ");
			String line = sc.nextLine().toLowerCase();
			
			if(line.equals("quit")) {
				System.out.println("작업을 종료하겠습니다.");
				break;
			}else if(line.equals("add")) {
				System.out.println(" 추가 작업을 선택하셨습니다. ");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				
				System.out.println("비밀번호 : ");
				String pwd = sc.nextLine();
				
				System.out.println("이름 : ");
				String name = sc.nextLine();
				
				System.out.println("주소 : ");
				String address = sc.nextLine();
				
				System.out.println(id +", "+ pwd +", "+ name +", "+ address);
			}else if(line.equals("retrieve")) {
				System.out.println(" 조회작업을 선택하셨습니다. ");
			}else if(line.equals("modify")) {
				System.out.println("수정작업을 선택하셨습니다.");
			}else {
				System.out.println("그외의 작업을 선택하셨습니다.");
			}
		}
	}
}
