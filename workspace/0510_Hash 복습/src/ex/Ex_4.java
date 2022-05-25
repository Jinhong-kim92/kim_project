package ex;

import java.util.Arrays;

class Solutionb {
	public boolean solution(String[] phone_book) {

		Arrays.sort(phone_book);
		for(int i = 0; i<phone_book.length-1; i++)
			if(!phone_book[i+1].equals(phone_book[i]))
				return false;
		
		
		return true;
		
	}

}

public class Ex_4 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solutionb sol = new Solutionb();
		System.out.println(sol.solution(phone_book));

	}

}
