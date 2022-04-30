package 람다식실습예제;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * 이번 예제는 람다식과 스트림이 포함된 예제
 */

public class LamdaEx01 {
	public static void main(String[] args) {
		//(1) 기존 방식으로 문제 해결
		/*
		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);		
		
		//Iterator는 외부 반복자이다.
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Integer value = iterator.next();
			System.out.println(value);
		}		
		*/
		//(2) 람다식과 스트림을 적용하여 문제 해결
		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);
		
		//Stream 내부 반복자 적용
		//[중요] 컬렉션으로부터 스트림 얻기 => List 컬렉션의 참조변수를 통해서
		Stream<Integer> stream = list.stream();
		stream.forEach(value -> System.out.println(value));		
	}
}










