package 연산자예제;

import java.util.Scanner;

/*
 *                        항1  
 * 삼항 연산자 예제 =>  변수 = (조건식) ? 항2 : 항3
 */

public class OperatorEx02 {
	public static void main(String[] args) {
		//int score = 85;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("점수 입력 >>> ");
		int score = scan.nextInt();
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		
		System.out.println("귀하의 학점은 " + grade + "입니다.");
	}
}
