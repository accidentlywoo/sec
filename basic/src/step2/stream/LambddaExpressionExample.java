package step2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambddaExpressionExample {
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(
				new Person(1, "gg", 2),
				new Person(2, "hh", 3)
				);
		Stream<Person> stream = list.stream();
		
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getId();
			System.out.println(name + " - " + score);
		});
	}
	
	
}
