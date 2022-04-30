package 자바로빅데이터처리예제;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		String str = "빅데이터의 다음 단계는 예측분석이다. 이제 예측분석의 키워드를 이해하는 기업만 살아남는다.";

		Pattern p = Pattern.compile("예측분석");
		Matcher m = p.matcher(str);
		
		int count = 0;
		String word = null;
		
		/*
		 * find() 메소드는 패턴이 일치하는 경우 true를 리턴하고, 그렇지 않으면 false를 리턴해주는 메소드
		 * group() 메소드는 매칭된 부분을 반환(return)해주는 메소드
		 */
		while(m.find()) {
			word = m.group(); //word라는 객체참조변수가 가리키는 문자열은 "예측분석" 이다.
			count++;
		}
		System.out.println("분석결과: " + "패턴일치");
		System.out.println(word + " " + count + "개");
	}
}




