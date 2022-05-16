import java.util.HashMap;
import java.util.Map;

class Solutionx {
	public boolean solution(String[] phoneBook) {
		// 1. HashMap�� �����Ѵ�.
		Map<String, Integer> map = new HashMap<>();
		// 2. ��� ��ȭ��ȣ�� HashMap�� �ִ´�.
		for (int i = 0; i < phoneBook.length; i++)
			map.put(phoneBook[i], i);
		// 3. ��� ��ȭ��ȣ�� substring�� HashMap�� �����ϴ��� Ȯ���Ѵ�.
		for (int i = 0; i < phoneBook.length; i++)
			for (int j = 1; j < phoneBook[i].length(); j++)
				if (map.containsKey(phoneBook[i].substring(0, j))) 
					//Ű���ִ���(�����ν�) ����Ʈ�� (Ű����_ó������ j��°)_�����ϸ� ��ġ�°�����)
//			containsKey(key)�ʿ��� ���ڷ� ���� Ű�� ������ true ������ false�� ��ȯ�Ѵ�
					return false;

		return true;
	}
}


public class Ex_2 {

	public static void main(String[] args) {

		String[] phone_book = { "119", "97674223", "1195524421" };
		Solutionx sol = new Solutionx();
		System.out.println(sol.solution(phone_book));

	}
}
