package algorithm;

public class StringToInt {
	public int solution(String s) {
		char flag = ' ';
		if(s.charAt(0) == '-') {
			flag =  '-';
			s = s.substring(1);
		}
		else if(s.charAt(0) == '+') {
			flag =  '+';
			s = s.substring(1);
		}
		
	    try {
			int answer =  Integer.parseInt(s);
			if(flag!=' ')
				answer = Integer.parseInt(flag+s);
			return answer;
		} catch (NumberFormatException  e) {
			return 0;// 숫자 변경 불가 문자열 입력
		}
    }
	public static void main(String[] args) {
		StringToInt s = new StringToInt();
		System.out.println(s.solution("-12"));
	}
}