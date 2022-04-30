package 스트림응용_회원들중남자회원의평균나이구하기;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MemberTest {

	public static void main(String[] args) {
		List<Member> list = (List)Arrays.asList(new Member("손흥민",Member.MALE,30),
				                          new Member("이강인",Member.MALE,26),
				                          new Member("김연아",Member.FEMALE,32),
				                          new Member("김은진",Member.FEMALE,28),
				                          new Member("안재홍",Member.MALE,35));
		
		/*
		 * 파이프라인을 자바 코드로 표현하면 다음과 같다.
		 * 스트림의 특징은 일회용이다.
		 * 스트림은 한번 사용하면 닫혀서 다시 사용할 수 없다.
		 * 필요하다면 스트림을 다시 생성해야 한다.
		 */
		/*
		Stream<Member> maleFemaleStream = list.stream();  //오리지날스트림
		Stream<Member> maleStream = maleFemaleStream.filter(m -> m.getGender() == Member.MALE);
		IntStream ageStream = maleStream.mapToInt(Member::getAge);
		OptionalDouble optionalDouble = ageStream.average();
		double ageAvg = optionalDouble.getAsDouble();
		*/
		
		
		//로컬변수를 생략하고 연결하면 다음과 같은 형태의 파이프라인 코드만 남는다.			
		double ageAvg = list.stream()
				            .filter(m -> m.getGender() == Member.MALE)
				            .mapToInt(Member::getAge)  // ::은 '메소드 참조'를 의미한다.
				            .average()
				            .getAsDouble();
		            
				            
		//기존의 코딩 방법으로 해결 => for문, if문을 적용하여
		/*
		int count = 0;
		double sum = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getGender() == Member.MALE) {
				sum += list.get(i).getAge();
				count++;
			}
		}
		double ageAvg = sum/count;
		*/
		
		System.out.println("남자 회원의 평균 나이: " + ageAvg);
		//남자 회원의 평균 나이: 30.333333333333332
		
		System.out.format("남자 회원의 평균 나이: %.2f", ageAvg);
		//남자 회원의 평균 나이: 30.33
	}
}




