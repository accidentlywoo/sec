package step2.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
	public static void main(String[] args) {
		// 숫자 요소일 경우
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream.sorted()
		.forEach(n -> System.out.println(n + ", "));
		
		List<Student> students = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
				);
		students.stream().sorted().forEach(s -> System.out.println(s.getScore()+", "));
		
		students.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getScore()+", "));
	}
}
