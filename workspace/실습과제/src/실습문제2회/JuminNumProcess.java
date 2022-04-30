package 실습문제2회;

import java.util.Scanner;

public class JuminNumProcess {

	public static void main(String[] args) {
		//준비 단계 => 변수 선언, 배열 선언 => 메모리의 일부(그릇) 
		String junminNum;  //키보드로부터 입력한 주민번호 문자열 객체의 주소값이 담겨질 객체 참조변수
		
		//입력 단계
		System.out.print("주민번호 입력 >>> ");
		Scanner scan = new Scanner(System.in);
		junminNum = scan.next();
		
		//처리 단계 => 제어문들의 조합(if문, switch문, for문, while문, continue, break)
		//logic => 인간의 논리적인 사고 => 주어진 문제를 어떻게 해결할것인지 고민?
		//[해결 방법 1]
		String frontJumin = junminNum.substring(0, 6);
		String backJumin = junminNum.substring(7, 14);
		
		//출력 단계
		System.out.println("주민번호 앞 6자리: " + frontJumin);
		System.out.println("주민번호 뒤 7 자리: " + backJumin);
		
		System.out.println();
		
		//[해결 방법 2]
		String[] token = junminNum.split("-"); 
		String frontString = token[0];
		String backString = token[1];
		
		System.out.println("주민번호 앞 6자리: " + frontString);
		System.out.println("주민번호 뒤 7 자리: " + backString);
		
		//[중요] 실무 사례
		// "971025-1054171" => "971025-1******"  => 마스킹(masking) 처리
		String juminNumMasking = backString.replace(backString.substring(1),"******");
		
		System.out.println("<< 주민번호 뒤자리 마스킹처리하기 >>");
		System.out.println(frontString + "-" + juminNumMasking);
	}
}












