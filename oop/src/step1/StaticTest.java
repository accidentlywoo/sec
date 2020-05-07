package step1;
class Single{
	int iv;
	static int sv;
	// modifier 의 순서가 바뀌어도 상관없다.
	private static Single s = new Single();
	private Single() {}
	static void test() {
//		System.out.println(this);
//		System.out.println(iv);
//		System.out.println(this.iv);
//		System.out.println(plus);
//		System.out.println(this.plus);
	}
	static void plus(int i) {
		sv =  sv+i;
	}
	static Single getInstance() {
		
		return s;
	}
}

public class StaticTest {
	public static void main(String[] args) {
		/*
		 * 대표적인 static method : System.out / Math
		 */
		double r = 5.6;
		System.out.println("원의 면적은 : "+ (Math.PI * Math.pow(r, 2)));
		
		double width = 3;
		double height = 4;
		
		double ss = Math.pow(width, 2)+Math.pow(height, 2);
		System.out.println("직각 삼각형의 빗변의 길이 : "+ Math.sqrt(ss));
		
		Math math;
		
		System.out.println(Math.hypot(width, height));
//		math = new Math(); 생성자 private로 선언되어있다.
//		Single s = new Single();
		
		System.out.println(Single.sv);
		Single.sv = 99;
		System.out.println(Single.sv);
		Single.plus(1);
		System.out.println(Single.sv);
		
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		System.out.println("Singleton Test : "+(s1 == s2));
		
		System.out.println(s1.sv);
		System.out.println(s2.sv);
		
		s1.iv = 99;
		System.out.println(s1.iv);
		System.out.println(s2.iv);
	}
}
