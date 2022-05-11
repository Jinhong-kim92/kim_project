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
			for (int j = 0; j < phoneBook[i].length(); j++)
				if (map.containsKey(phoneBook[i].substring(0, j)))
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
