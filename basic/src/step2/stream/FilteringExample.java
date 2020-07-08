package step2.stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("�����", "���ؽ�", "�ڼ���", "����", "������","�����","����");
		
		names.stream()
		.distinct()
		.forEach(n -> System.out.println(n));
		
		System.out.println();
		
		names.stream()
		.distinct()
		.filter(n -> n.startsWith("��"))
		.forEach(n -> System.out.println(n));
		
	}
}
