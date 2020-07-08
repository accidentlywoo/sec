package step2.stream;

import java.util.Arrays;
import java.util.List;

public class MapAndResuceExample {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("ȫ�浿", 10),
				new Student("�ſ��", 20),
				new Student("���̼�", 30)
				);
		
		double avg = students.stream()
		//�߰� ó��
		.mapToInt(Student::getScore)
		//���� ó��
		.average()
		.getAsDouble();
		System.out.println("��� ���� : " + avg); 
	}
}
