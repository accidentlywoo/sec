package step2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionExample {
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(
				new Person(1, "a", 10),
				new Person(2, "b", 20)
				);
		Stream<Person> stream = list.stream();
		stream.forEach(s ->{
			String name = s.getName();
			int age = s.getAge();
			System.out.println(name + "-" +age);
		});
	}
}
