package step1;

import java.util.Arrays;
import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		int maxRow = 2;
		String[][] personInfo = new String[maxRow][4];
		int row = 0;
		while(true) {
			System.out.println("문자열을 입력하세요.  (add : 추가 작업, retrieve : 조회 작업, modify : 수정 작업, quit : 종료 작업)) : ");
			String line = sc.nextLine().toLowerCase();
			
			if(line.equals("quit")) {
				System.out.println("작업을 종료하겠습니다.");
				break;
			}else if(line.equals("add")) {
				
				System.out.println(" 추가 작업을 선택하셨습니다. ");
				System.out.println("현재 저장인원 : " + (row) + "명");
				
				if(row >= maxRow) {
					System.out.println("저장소가 꽉 찼습니다. ");
					break;
				}
				
				System.out.println("아이디 : ");
				String idCheck = sc.nextLine();
				boolean flag = false;
				for(int i = 0; i < row; i++) {
					if(personInfo[i][0].equals(idCheck)) {
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println("아이디 중복입니다. 다른 아이디를 입력하시오.");
				}else {
					personInfo[row][0] = idCheck;
					System.out.println("비밀번호 : ");
					personInfo[row][1] = sc.nextLine();
					
					System.out.println("이름 : ");
					personInfo[row][2] = sc.nextLine();
					
					System.out.println("주소 : ");
					personInfo[row][3] = sc.nextLine();
					
					System.out.println(Arrays.deepToString(personInfo));
					row++;
				}
			}else if(line.equals("retrieve")) {
				System.out.println(" 조회작업을 선택하셨습니다. ");
				for(int i = 0; i < row; i++) {
					String id = personInfo[i][0];
					System.out.println((i+1)+"번째 아이디 출력 : "+id);
				}
			}else if(line.equals("modify")) {
				System.out.println("수정작업을 선택하셨습니다.");
			}else {
				System.out.println("그외의 작업을 선택하셨습니다.");
			}
		}
	}
}
