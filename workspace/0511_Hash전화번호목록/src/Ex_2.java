import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solutionx {
	public boolean solution(String[] phoneBook) {
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i<phoneBook.length; i++)
			map.put(phoneBook[i], i);
		for(int i = 0; i<phoneBook.length; i++) {
			for(int j = 1; j<phoneBook[i].length(); j++) {
				if(map.containsKey(phoneBook[i].substring(0, j)))
					return false;
			}
		}

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
