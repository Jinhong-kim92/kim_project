package 실습문제2회;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreeSixNineGame02 {
	public static void main(String[] args) {
		String[] ans = {"입력된 값에 369가 포함되어 있지 않습니다", "박수짝","박수짝짝","박수짝짝짝"};
		
		//입력 단계
		System.out.print("1~9999 사이의 값을 입력하세요 >>> ");
		Scanner scan = new Scanner(System.in);		
		String inputNum = scan.next();
		
		//처리 단계 => 소스의 최적화, 가독성이 좋다.
		if(inputNum.length() > 4) {
			System.out.println("입력된 값이 범위를 초과했습니다.");
		}else {
			int count = 0;
			Pattern p = Pattern.compile("[3,6,9]");
			Matcher m = p.matcher(inputNum);
			
			while(m.find()) {
				count++;
			}
			System.out.println(ans[count]);  //[중요]
		}
	}
}
