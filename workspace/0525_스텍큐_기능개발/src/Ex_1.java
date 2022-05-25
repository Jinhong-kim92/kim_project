import java.util.ArrayList;
import java.util.List;

class Solutionc {
	public int[] solution(int[] progresses, int[] speeds) {

		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
//        	1. 한개 기능을 개발하는데 필요한 날짜계산
			double days = (100 - progresses[i]) / (double) speeds[i];
//        	몇일이 걸리는지 계산
			int daysUp = (int) Math.ceil(days);
//        	정수형 데이트 필요,  데이즈라는 실수를 올림하고 올림한 값을 인트로 케스팅해서 데이즈업에 담음
			int j = i + 1;

			for (; j < progresses.length; j++)
				// 배포할 수 있는지 없는지를 판단하게 하기위함
				if (progresses[j] + daysUp * speeds[j] < 100)
					break;
			// 프로그레스에 데이즈업만큼 지나가지 않았다면 브레이크 . 멈추면 배포할 수 없는 첫번째 인덱스값
			answer.add(j - i); // 함께 배포할 수 없는 첫번째 인덱스 값에서 현재기능의 위치를 빼면 그 사이에 몇개 배포할지 차이값 담김
			i = j - 1; // j에서부터 시작하기 위해서

		}
		return answer.stream().mapToInt(i -> i.intValue()).toArray();

		// answer 는 integer 의 arraysList 였고 stream을 해서 인티져 객체를 하나하나씩 꺼내오고 그 인티져 객체를 인트
		// 값으로 변환했고, 그것을 어레이값으로 변환

	}

}
