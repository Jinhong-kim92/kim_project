import java.util.HashMap;
import java.util.Map;

class Solutionx {
	public boolean solution(String[] phoneBook) {
		// 1. HashMap을 선언한다.
		Map<String, Integer> map = new HashMap<>();
		// 2. 모든 전화번호를 HashMap에 넣는다.
		for (int i = 0; i < phoneBook.length; i++)
			map.put(phoneBook[i], i);
		// 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
		for (int i = 0; i < phoneBook.length; i++)
			for (int j = 1; j < phoneBook[i].length(); j++)
				if (map.containsKey(phoneBook[i].substring(0, j))) 
					//키가있는지(컨테인스) 섭스트링 (키전달_처음부터 j번째)_존재하면 겹치는거있음)
//			containsKey(key)맵에서 인자로 보낸 키가 있으면 true 없으면 false를 반환한다
					return false;

		return true;
	}
}


public class Ex_2 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solutionx sol = new Solutionx();
		System.out.println(sol.solution(phone_book));

	}
}
