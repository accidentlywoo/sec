package step2.stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("±è»óÇÏ", "°íÁØ½Ä", "¹Ú¼º¿î", "µ¿ÀÏ", "¼ÕÁö¿ø","±è»óÇÏ","±è±è±è");
		
		names.stream()
		.distinct()
		.forEach(n -> System.out.println(n));
		
		System.out.println();
		
		names.stream()
		.distinct()
		.filter(n -> n.startsWith("±è"))
		.forEach(n -> System.out.println(n));
		
	}
}
