package step2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","b","c","d","e","f","g");
		
		// 순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ParallelExample :: print);
		System.out.println();
		
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelExample :: print);
	}
	public static void print(String str) {
		System.out.println(str+" : "+ Thread.currentThread().getName());
	}
}
