package step2.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("ȫ���", Member.MALE, 30),
				new Member("�質��", Member.FEMALE, 20),
				new Member("�úػ�", Member.MALE, 12),
				new Member("������", Member.MALE, 27)
				);
		double ageAvg = list.stream()
				.filter(m -> m.getSex()==Member.MALE)
				.mapToInt(Member::getAge)
				.average()
				.getAsDouble();
		System.out.println("���� ��� ���� : " + ageAvg);
	}
}
