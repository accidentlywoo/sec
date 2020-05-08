package algorithm;

public class StringToInt {
	public int solution(String s) {
	    try {
			int answer =  Integer.parseInt(s);
			return answer;
		} catch (NumberFormatException  e) {
			return 0;
		}
    }
}
