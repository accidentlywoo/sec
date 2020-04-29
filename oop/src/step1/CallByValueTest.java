package step1;

import java.util.Arrays;

public class CallByValueTest {

	static void m(int i) {
		i = 100;
	}
	
	static void mArr(int[] arr) {
		System.out.println("외부 메소드에서 매개변수로 받은 : "+arr);
		arr[0] = 100;
	}
	
	public static void main(String[] args) {
		int i = 1;
		m(i);
		System.out.println(i);
		
		int[] arr = {1, 2, 3};
		System.out.println("main 내부 : "+arr);
		mArr(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
}
