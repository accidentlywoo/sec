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
		//return (name + "���� �ּҴ� "+addr+"�Դϴ�.");
		System.out.println(name + "���� �ּҴ� "+addr+"�Դϴ�.");
	}
	
	public static void main(String[] args) {
		int kS, eS, mS;
		kS = 100;
		eS = 50;
		mS = 46;
		float avg = calculateAvg(kS, eS, mS);
		System.out.println(avg);
		
		String name = "�쿩��";
		String addr = "����� ���ı�";
		printInfo(name, addr); 
		
		// �Ű������� �������� �ٲ�� �޼ҵ�
		int[] scores = {100, 50, 46, 97, 65};
		System.out.println("��� : " + calculateAvg(scores));
	}
}
