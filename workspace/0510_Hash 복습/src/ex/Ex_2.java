package ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solutions {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String , Integer> map = new HashMap<>();
		for(String player : participant)
			map.put(player, map.getOrDefault(player, 0)+1);
		for(String player : completion)
			map.put(player, map.get(player)-1);
		for(String key : map.keySet()) {
			if(map.get(key)!=0) {
				answer = key;
				break;
				
			}
			
		}
	
			


		return answer;

	}
}

public class Ex_2 {

	public static void main(String[] args) {

		String[] part = { "leo", "kiki", "eden" };
		String[] comp = { "kiki", "eden" };
		Solutions sol = new Solutions();
		System.out.println(sol.solution(part, comp));

	}

}
