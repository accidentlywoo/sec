package step2.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
	public static void main(String[] args) {
		// ���� ����� ���
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream.sorted()
		.forEach(n -> System.out.println(n + ", "));
		
		List<Student> students = Arrays.asList(
				new Student("ȫ�浿", 10),
				new Student("�ſ��", 20),
				new Student("���̼�", 30)
				);
		students.stream().sorted().forEach(s -> System.out.println(s.getScore()+", "));
		
		students.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getScore()+", "));
	}
}
