package step2.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample {
	public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 4, 5};
		
		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream()
		.forEach(d -> System.out.println(d));
		
		//ERROR : stream has already been operated upon or closed
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(obj -> System.out.println(obj.intValue()));
		
	}
}
