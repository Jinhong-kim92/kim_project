import java.util.Arrays;

class Solution {
	public boolean solution(String[] phone_book) {

// 1. 폰북 정렬
// 2. 1중 루프 돌면서 앞번호와 뒷번호의 접두어 확인
//		3. 없으면 true 잇으면 false

		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i]))
				return false;
		}

		return true;

	}
}

public class Ex_1 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solution sol = new Solution();
		System.out.println(sol.solution(phone_book));

	}

}
