package step2.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("È«±æ¶Ë", Member.MALE, 30),
				new Member("±è³ª¸®", Member.FEMALE, 20),
				new Member("½ÃºØ»õ", Member.MALE, 12),
				new Member("ÀÎÀý¹Ì", Member.MALE, 27)
				);
		double ageAvg = list.stream()
				.filter(m -> m.getSex()==Member.MALE)
				.mapToInt(Member::getAge)
				.average()
				.getAsDouble();
		System.out.println("³²ÀÚ Æò±Õ ³ªÀÌ : " + ageAvg);
	}
}
