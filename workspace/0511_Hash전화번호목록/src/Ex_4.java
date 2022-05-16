import java.util.Arrays;

class Solutionv {
	public boolean solution(String[] phone_book) {

		boolean answer = true;
		Arrays.sort(phone_book);
		
		for(int i = 0; i<phone_book.length -1; i++)
			if(phone_book[i+1].startsWith(phone_book[i]))
				return false;
		
		return answer;

	}
}

public class Ex_4 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solutionv sol = new Solutionv();
		System.out.println(sol.solution(phone_book));

	}

}
