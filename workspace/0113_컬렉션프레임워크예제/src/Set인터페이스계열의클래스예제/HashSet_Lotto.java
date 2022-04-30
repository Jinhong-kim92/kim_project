package Set인터페이스계열의클래스예제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * HashSet 객체를 생성하면 객체 정렬이 되지 않음!!
 */
public class HashSet_Lotto {

	public static void main(String[] args) {
		Set set = new HashSet();
		
		for(int i=0; set.size() < 6; i++) {
			Random rnd = new Random();	//난수 발생하는 클래스
			int number = rnd.nextInt(45)+1;  //1 ~ 45까지의 난수 발생
			set.add(new Integer(number));
		}
		
		List list = new ArrayList(set);
		Collections.sort(list);
		System.out.println("<< 로또번호 보여주기 >>");
		System.out.println(list);
	}
}



