import java.util.HashMap;
import java.util.Iterator;

//1. 옷을 종류별로 구분한다.
//2. 입지않는 경우를 추가해서 모든 조합을 계산한다.
//3. 아무종류의 옷도 입지 않는 경우 제외한다.
class Solution {
	public int solution(String[][] clothes) {

		HashMap<String, Integer> map = new HashMap<>();
		for (String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}

		Iterator<Integer> it = map.values().iterator();
		int answer = 1;
		while (it.hasNext()) {
			answer *= it.next().intValue() + 1;
		}

		return answer -1 ;

	}
}

public class Ex_1 {

	public static void main(String[] args) {

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		Solution sol = new Solution();
		System.out.println(sol.solution(clothes));

	}

}
