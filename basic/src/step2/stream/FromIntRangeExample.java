package step2.stream;

import java.util.stream.IntStream;

public class FromIntRangeExample {
	public static int sum;
	
	public static void main(String[] args) {
		IntStream stream = IntStream.range(1,  100);
		stream.forEach( a -> sum += a);
		System.out.println("รัวี : " + sum);
	}
}
