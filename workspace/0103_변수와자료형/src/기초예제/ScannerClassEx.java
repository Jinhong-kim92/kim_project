package 기초예제;

import java.util.Scanner;

public class ScannerClassEx {

	public static void main(String[] args) {
		//Scanner 클래스 객체 생성 방법
		Scanner scan = new Scanner(System.in);
		
		System.out.print("실수 입력 >>> ");
		double inputDouble = scan.nextDouble();
		System.out.println(inputDouble);
		
		/*
		System.out.print("정수 입력 >>> ");
		int inputInt = scan.nextInt();
		System.out.println(inputInt);
		*/
		
		/*
		System.out.print("문자열 입력 >>> ");
		String inputString = scan.nextLine();
		System.out.println(inputString);
		*/
	}
}







