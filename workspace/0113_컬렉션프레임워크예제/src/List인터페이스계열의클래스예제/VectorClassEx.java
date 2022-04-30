package List인터페이스계열의클래스예제;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorClassEx {
	public static void main(String[] args) {
		//고정 배열 객체 생성
		String[] name = {"김진명","최인호","조정래","김홍신","박경리"};

		//가변 배열 객체 생성    <E>  제네릭 기능 => Element(요소)
		//List<객체타입> 참조변수 = new 생성자<객체타입>(매개변수1, 매개변수2);
		//List<String> list = new Vector<String>();   //기본 10개의 공간 확보
		List<String> list = new Vector<String>(4,3);
		
		System.out.println("벡터의 용량은: " + ((Vector<String>) list).capacity());
		//벡터의 용량은: 4
		
		//고정 배열의 String 객체들을 Vector 가변배열에 저장하기
		for(int i=0; i<name.length; i++) {
			list.add(name[i]);
		}
		System.out.println(list);
		//[김진명, 최인호, 조정래, 김홍신, 박경리]   //객체와 객체 사이는 ,공백으로 구분된다.
		
		System.out.println("벡터의 용량은: " + ((Vector<String>) list).capacity());
		//벡터의 용량은: 7
		
		System.out.println("벡터에 저장된 요소의 개수는 " + list.size()); //객체의 개수 얻어오기
		//벡터에 저장된 요소의 개수는 5
		
		//객체 추가
		list.add("박근혜");	//마지막에 추가
		System.out.println(list);
		//[김진명, 최인호, 조정래, 김홍신, 박경리, 박근혜]
		
		//가변배열 중간에 객체 끼어넣기(삽입)		
		//김진명과 최인호 사이에 "공지영"을 삽입하고자 한다.		
		list.add(1, "공지영");
		System.out.println(list);
		//[김진명, 공지영, 최인호, 조정래, 김홍신, 박경리, 박근혜]
		
		//객체 검색
		System.out.println(list.get(2));  //최인호 출력
		
		boolean cotains_result = list.contains("김홍신");
		System.out.println(cotains_result);   //true 출력
		
		boolean cotains_result2 = list.contains("홍길동");
		System.out.println(cotains_result2);   //false 출력
		
		for(String item : list) {	//향상된 for문
			System.out.print(item + "\t");
		}
		//김진명	  공지영	최인호	조정래	김홍신	박경리	박근혜
		
		System.out.println(); //줄바꿈
		
		/* 객체 수정하기 => 최인호 객체를 이문열 객체로 수정하기 */
		list.set(2, "이문열");
		System.out.println(list);
		//[김진명, 공지영, 이문열, 조정래, 김홍신, 박경리, 박근혜]
		
		System.out.println(); //줄바꿈
		
		/* 객체 삭제하기 => 조정래 객체 삭제하기 */
		list.remove(3);
		System.out.println(list);
		//[김진명, 공지영, 이문열, 김홍신, 박경리, 박근혜]
		
		System.out.println(); //줄바꿈
		
		/* 객체 삭제하기 => 공지영 객체 삭제하기 */
		list.remove("공지영");
		System.out.println(list);
		//[김진명, 이문열, 김홍신, 박경리, 박근혜]
		
		System.out.println(); //줄바꿈
		
		/* 가변 배열의 객체 정렬하기 => 오름 차순(Ascending Sort 약자로 asc) */
		System.out.println("[객체 오름차순 정렬하기 ");
		Collections.sort(list);
		System.out.println(list);
		//[김진명, 김홍신, 박경리, 박근혜, 이문열]
		
		System.out.println(); //줄바꿈
		
		/* 가변 배열의 객체 정렬하기 => 내림 차순(Descending Sort 약자로 desc) */
		System.out.println("[객체 내림차순 정렬하기 ");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		//[이문열, 박근혜, 박경리, 김홍신, 김진명]	
		
		System.out.println(); //줄바꿈
		list.add("김홍신");  //Vector 객체는 중복 저장 가능
		System.out.println(list);
		//[이문열, 박근혜, 박경리, 김홍신, 김진명, 김홍신]
	}
}














