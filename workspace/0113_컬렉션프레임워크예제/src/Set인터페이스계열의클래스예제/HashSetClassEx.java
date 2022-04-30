package Set인터페이스계열의클래스예제;

import java.util.HashSet;
import java.util.Set;

/*
 * HashSet은 객체를 저장하기 전에 
 * 먼저 객체의 hashCode() 메소드를 호출해서 해시코드를 얻어온다.
 * 그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다.
 * 만약 동일한 해시코드가 있다면 equals() 메소드로 두 객체를 비교해서
 * true가 나오면 동일한 객체로 판단하고 중복 저장을 하지 않는다.
 */

public class HashSetClassEx {

	public static void main(String[] args) {
		//HashSet 객체 생성
		Set<Member> member_set = new HashSet<Member>();
		
		//[사례] 금융권 => 똑 같은 객체가 두 개이면 않된다. 오직 하나의 객체만 생성되어야 한다.
		Member member1 = new Member("손흥민", 31, "111111-1111111");
		Member member2 = new Member("손흥민", 31, "111111-1111111");
		
		member_set.add(member1);
		member_set.add(member2);
		
		System.out.println("객체의 총개수는? " + member_set.size());
		//객체의 총개수는? 1
		
		System.out.println(member1.hashCode());  //-1166721462
		System.out.println(member2.hashCode());  //-1166721462
		
		System.out.println(member1.equals(member2));  //true
	}
}




