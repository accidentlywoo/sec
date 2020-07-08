package step2.stream;

import java.util.Arrays;
import java.util.List;

public class MapAndResuceExample {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
				);
		
		double avg = students.stream()
		//중간 처리
		.mapToInt(Student::getScore)
		//최종 처리
		.average()
		.getAsDouble();
		System.out.println("평균 점수 : " + avg); 
	}
}
