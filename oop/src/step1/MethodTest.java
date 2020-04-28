package step1;

public class MethodTest {

	static float calculateAvg(int a, int b, int c) {
		float result=(a + b + c)/3F;
		return result;
	}
	public static void main(String[] args) {
		
		int kS, eS, mS;
		kS = 100;
		eS = 50;
		mS = 46;
		float avg = calculateAvg(kS, eS, mS);
		System.out.println(avg);
	}
}
