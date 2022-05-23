package Ex_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
	public String solution(String[] participant, String[] completion) {

		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (String player : participant)
			map.put(player, map.getOrDefault(player, 0) + 1);
		for (String player : completion)
			map.put(player, map.get(completion));
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		Map.Entry<String, Integer> entry = iter.next();
		while (iter.hasNext()) {
			if (entry.getValue() != 0) {
				answer = entry.getKey();
				break;
			}
		}

		return answer;

	}
}

public class Ex_2 {

	public static void main(String[] args) {

		String[] part = { "leo", "kiki", "eden" };
		String[] comp = { "eden", "kiki" };
		Solution sol = new Solution();
		System.out.println(sol.solution(part, comp));

	}

}
