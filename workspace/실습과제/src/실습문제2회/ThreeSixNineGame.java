package 실습문제2회;

import java.util.Scanner;

public class ThreeSixNineGame {
	public static void main(String[] args) {
		//준비 단계
		String inputNum;
		int count = 0;
		int noOf369_count = 0;
		
		//입력 단계
		System.out.print("1~9999 사이의 값을 입력하세요 >>> ");
		Scanner scan = new Scanner(System.in);		
		inputNum = scan.next();
		
		//처리 단계
		if(inputNum.length() <= 4) {
			for(int i=0; i<inputNum.length(); i++) {
				if(inputNum.charAt(i)-48 == 3 || inputNum.charAt(i)-48 == 6
						                      || inputNum.charAt(i)-48 == 9) {
					count = count + 1;
				}
				if(inputNum.charAt(i)-48 != 3 || inputNum.charAt(i)-48 != 6
	                      || inputNum.charAt(i)-48 != 9) {
					noOf369_count = noOf369_count + 1;
				}
			}
		}
		if(count > 0) {
			System.out.print("박수");
			for(int j=0; j<count; j++) {
				System.out.print("짝");
			}
		}
		if(noOf369_count > 0 && count == 0) {
			System.out.println("입력된 값에 369가 포함되어 있지 않습니다!!");
		}
		if(inputNum.length() > 4) {
			System.out.println("입력된 값이 범위를 초과했습니다.");
		}
	}

	
	
	
	
	

}
