package 실습문제1회;

import java.util.Scanner;

public class LeapyearCommonyear {

	public static void main(String[] args) {
		//준비
		int year;
		
		//입력
		System.out.print("년도를 입력하세요 >>> ");
		Scanner scan = new Scanner(System.in);
		year = scan.nextInt();		
		/*
		 * 윤년 조건
		 * 4로 나누어 떨어지고 100으로 나누어 떨어지지 않거나
		 * 400으로 나누어 떨어지는 경우
		 */
		//처리
		
		if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			System.out.println("입력한 년도는 윤년입니다.");
		}else {
			System.out.println("입력한 년도는 평년입니다.");
		}
		scan.close();
	}
}




