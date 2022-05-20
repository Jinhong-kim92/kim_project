package Ex_2;

import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		
		String answer = "";
	    
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < participant.length; i++)
			map.put(player, map.getOrDefault(player, 0) +1);
		
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
