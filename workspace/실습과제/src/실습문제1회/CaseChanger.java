package 실습문제1회;

import java.util.Scanner;

public class CaseChanger {

	public static void main(String[] args) {
		//준비 단계
		char alpha;
		
		//입력 단계
		System.out.print("문자 한 자를 입력하세요 >>> ");
		Scanner scan = new Scanner(System.in);
		/*
		 * 'A' => 65
		 * "A" => "A\0"
		 */
		alpha = scan.next().charAt(0);
		
		if(alpha >= 'a' && alpha <= 'z') { //&& AND 연산자,    || OR 연산자
			//좌변 = 우변;
			alpha = (char) (alpha - 32);
		}else if(alpha >= 'A' && alpha <= 'Z') { //&& AND 연산자,    || OR 연산자			
			alpha = (char) (alpha + 32);
		}else { //한글이 입력된 경우
			System.out.println("영문자가 아닙니다.");
			System.exit(0);   //프로그램 정상 종료
		}
		System.out.println(alpha);
		scan.close();
	}
}









