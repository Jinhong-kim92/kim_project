package 스트림을얻어오는방법예제;

import java.util.stream.IntStream;

public class FromIntRangeEx {
	public static int sum; //클래스 변수,  0으로 자동 초기화
	
	public static void main(String[] args) {
		//숫자범위로부터 스트림 얻기
		IntStream intStream = IntStream.rangeClosed(1, 100);  //1 ~ 100까지 범위		
		intStream.forEach(num -> sum+=num);
		System.out.println("합계: " + sum);
	}
}
