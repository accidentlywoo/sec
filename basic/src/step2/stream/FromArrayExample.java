package step2.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {
		String[] strArray = {"È«±æµ¿", "¿ì¿©´Ï", "¶Ë³¢"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(s -> System.out.println(s + ", "));
		
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(s -> System.out.println(s +", "));
	}
}
