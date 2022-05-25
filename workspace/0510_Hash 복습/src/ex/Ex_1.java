package ex;

import java.util.Arrays;

class Solution {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for(; i<completion.length; i++)
        	if(!participant[i].equals(completion[i]))
        		break;
        return participant[i];

    }
}

public class Ex_1 {

	public static void main(String[] args) {

		String[] parti = { "leo", "kiki", "eden" };
		String[] compl = { "kiki", "eden" };
		Solution sol = new Solution();
		System.out.println(sol.solution(parti, compl));

	}

}
