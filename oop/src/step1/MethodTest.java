package step1;

public class MethodTest {

	static float calculateAvg(int a, int b, int c) {
		float result=(a + b + c)/3F;
		return result;
	}
	
	static float calculateAvg(int[] a) {
		float result = 0;
		for(int item : a) {
			result+=item;
		}
		result = result / (a.length);
		return result;
	}
	static void printInfo(String name, String addr) {
		//return (name + "님의 주소는 "+addr+"입니다.");
		System.out.println(name + "님의 주소는 "+addr+"입니다.");
	}
	
	public static void main(String[] args) {
		
		int kS, eS, mS;
		kS = 100;
		eS = 50;
		mS = 46;
		float avg = calculateAvg(kS, eS, mS);
		System.out.println(avg);
		
		String name = "우여니";
		String addr = "서울시 송파구";
		printInfo(name, addr); 
		
		// 매개변수가 동적으로 바뀌는 메소드
		int[] scores = {100, 50, 46, 97, 65};
		System.out.println("평균 : " + calculateAvg(scores));
	}
}
