package step1;
class Datatype{
	public static void main(String[] args){
		byte b1; // 변수 선언
		short s1, s2;
		int num;
		long large1;
		
		b1 = 1; //변수 값 대입
		b1 = 2; 
		//b1 = 3.5;
	
		b1 = -128;
		//b1 = -129;
		b1 = 127;
		//b1 = 128;
		
		large1 = 1; // int 리터럴
		large1 = 1L; // long 리터럴(대문자가 가독성이 좋다.)
		// 퍼포먼스 차이없다.

		/*
		 * 자동 형변환
		 * byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
		 */

		double d; //8 바이트
		d = 12.3;

		float f; //4 바이트
		//f = 12.3; // 기본 Double타입이 들어간다. 컴파일 에러
		f = 12.3F;
		f = (float)12.3; // 강제형 변환 () : 캐스트 연산자

		num = (int)f;

		System.out.println(f);

		System.out.println(num);

		System.out.println(123); // int 타입 리터럴

		System.out.println(123.45); // double 타입 리터럴

		//System.out.println(100000000000000000); // 컴파일 오류

		System.out.println(100000000000000000L); // long 타입 리터럴


		// 지동형변환 : char -> int -> long -> float -> double
		char c; //2byte unicode
		c = 'A';
		c = 65;
		// 영어, 숫자형 문자, 특수문자
		//c = '가';
		c = 44032;
		
		System.out.println(c);


		/*
		* UTF-8 을 사용하면 영어문자에서 ASCII코드만큼의 메모리를 사용하기 때문에 메모리 낭비를 줄일 수 있다.
		*/

		num = c;
		System.out.println(num);
		c = (char)num;
		System.out.println(c);

		c = 'A';
		System.out.println(c);
	
		c = 'A'+1;
		System.out.println(c);
		
		c = 'A'+2;
		System.out.println(c);

		System.out.println((char)('A'+3));

		boolean flag; // 1byte 형변환 없다. (C, Python 쌉 가능)
	
		flag = true;
		flag = false;
		//flag = 1; 컴파일 오류

		int score; // 국어 점수
		boolean study; // 수업 참여여부
		double avg; // 평균
		char grade; // 학점
	}
}