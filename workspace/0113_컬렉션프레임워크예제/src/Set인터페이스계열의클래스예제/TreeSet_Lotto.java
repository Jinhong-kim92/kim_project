package Set인터페이스계열의클래스예제;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* 
 * TreeSet으로 객체를 생성하여 저장하면 저장되면서 자동 정렬 시킨다.
 */
public class TreeSet_Lotto {

	public static void main(String[] args) {
		Set set = new TreeSet();
		
		for(int i=0; set.size() < 6; i++) {
			Random rnd = new Random();	//난수 발생하는 클래스
			int number = rnd.nextInt(45)+1;  //1 ~ 45까지의 난수 발생
			set.add(new Integer(number));
		}
		
		System.out.println("<< 로또번호 보여주기 >>");
		System.out.println(set);
	}
}



