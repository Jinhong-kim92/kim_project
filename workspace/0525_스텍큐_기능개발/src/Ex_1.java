import java.util.ArrayList;
import java.util.List;

class Solutionc {
	public int[] solution(int[] progresses, int[] speeds) {

		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
//        	1. �Ѱ� ����� �����ϴµ� �ʿ��� ��¥���
			double days = (100 - progresses[i]) / (double) speeds[i];
//        	������ �ɸ����� ���
			int daysUp = (int) Math.ceil(days);
//        	������ ����Ʈ �ʿ�,  �������� �Ǽ��� �ø��ϰ� �ø��� ���� ��Ʈ�� �ɽ����ؼ� ��������� ����
			int j = i + 1;

			for (; j < progresses.length; j++)
				// ������ �� �ִ��� �������� �Ǵ��ϰ� �ϱ�����
				if (progresses[j] + daysUp * speeds[j] < 100)
					break;
			// ���α׷����� ���������ŭ �������� �ʾҴٸ� �극��ũ . ���߸� ������ �� ���� ù��° �ε�����
			answer.add(j - i); // �Բ� ������ �� ���� ù��° �ε��� ������ �������� ��ġ�� ���� �� ���̿� � �������� ���̰� ���
			i = j - 1; // j�������� �����ϱ� ���ؼ�

		}
		return answer.stream().mapToInt(i -> i.intValue()).toArray();

		// answer �� integer �� arraysList ���� stream�� �ؼ� ��Ƽ�� ��ü�� �ϳ��ϳ��� �������� �� ��Ƽ�� ��ü�� ��Ʈ
		// ������ ��ȯ�߰�, �װ��� ��̰����� ��ȯ

	}

}
