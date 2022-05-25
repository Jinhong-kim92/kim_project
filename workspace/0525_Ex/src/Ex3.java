import java.util.HashMap;
import java.util.Iterator;

class Solutioncv {
	public int solution(String[][] clothes) {
		
		HashMap <String, Integer> map = new HashMap<>();
		for(String[] cloth : clothes ) {
			String type = cloth[1];
			map.put(type, map.getOrDefault(type, 0)+1);
		}	
		Iterator<Integer> it = map.values().iterator();
		
		int answer = 1;
		while(it.hasNext()) {
			answer *= it.next().intValue()+1;
		}


		return answer-1;

	}
}

public class Ex3 {

	public static void main(String[] args) {

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		Solutioncv sol = new Solutioncv();
		System.out.println(sol.solution(clothes));

	}

}
