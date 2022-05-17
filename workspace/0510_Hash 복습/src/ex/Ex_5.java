package ex;

import java.util.HashMap;

class Solutionn {
	public boolean solution(String[] phone_book) {

		boolean answer = true;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i< phone_book.length; i++)
			map.put(phone_book[i],i);
		for(int i = 0; i<phone_book.length; i++)
			for(int j =1; j<phone_book[i].length(); j++)
				if(map.containsKey(phone_book[i].substring(0,j)))
					return false;
		
	
		
		
		return true;

	}

}

public class Ex_5 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solutionn sol = new Solutionn();
		System.out.println(sol.solution(phone_book));

	}

}
