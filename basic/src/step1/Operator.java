package step1;
class Operator{
	public static void main(String[] args){
		System.out.println("짝수인지 비교할 숫자를 입력하세요");
		int a;
		//a = 100;

		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		a = sc.nextInt();

		// a변수값이 짝수이면 true를 출력
		//	     홀수이면 false를 출력
		int b = a%2;
		System.out.println(b == 0 ? "짝" : "홀");

		// 연산자 자동형변환	
		short s1, s2, s3;
		s1 = 5;
		s2 = 8;
		s3 = (short)(s1 + s2);

		System.out.println(s3);

		byte c;
		c = 127;
		c++;
		System.out.println(c);

		// 나누기 연산자
		int num = 6;
		//System.out.println(num/0); ArithmeticException
		System.out.println(num / 3.5);

		System.out.println("평균구할 점수를 입력하시오");

		System.out.println("국어를 입력하시오 : ");
		int korean = sc.nextInt();

		System.out.println("수학를 입력하시오 : ");
		int methmatics = sc.nextInt();

		System.out.println("영어를 입력하시오 : ");
		int english = sc.nextInt();
		float avg = (korean + methmatics + english )/3F;

		System.out.println("평균은 " + avg +"점 입니다.");
		System.out.println(((int)(avg*10))/10F);
	}
}