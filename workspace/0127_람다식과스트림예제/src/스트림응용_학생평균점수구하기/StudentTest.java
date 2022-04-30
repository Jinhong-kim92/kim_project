package 스트림응용_학생평균점수구하기;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		List<Student> studentList = (List)Arrays.asList(new Student("김은진",90),
				                                        new Student("박태호",100),
				                                        new Student("손유일",80),
				                                        new Student("오수철",70),
				                                        new Student("안재홍",80));
		
		//[중요] 파이프 라인 구조
		double avg = studentList.stream()
				                .mapToInt(Student::getScore)
				                .average()
				                .getAsDouble();
		
		System.out.println("평균점수: " + avg);
	}
}



