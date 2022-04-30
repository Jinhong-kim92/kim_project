package 금액에꼼마넣기예제;

import java.text.DecimalFormat;

/*
 * 유틸리티 클래스란 여러 클래스에서 유용하게 "공유"해서 
 * 사용할 수 있는 클래스를 의미한다.
 * DecimalFormat(String pattern) 생성자 적용
 */
public class Utils {
	//넘겨받은 금액에 천단위 마다 꼼마(,)를 넣는 메소드 구현
	/*
	 * 메소드 구현 방법
	 * 접근지정자 static(유무) 반환타입  메소드이름(자료형 매개변수1, ..., 자료형 매개변수n) {
	 *      실행할 문장
	 *      . . . 
	 * }     
	 */
	public static String toNumberFormat(long totalAmount) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(totalAmount);
	}	
}







