package 제어문예제;

/*
 * 1부터 100까지의 짝수의 합을 구하는 프로그램 작성
 */

public class ForEx03 {
	public static void main(String[] args) {
		int evenSum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%2 != 0) {
				evenSum = evenSum + i;
			}
		}
		System.out.println("1부터 100까지의 짝수의합은 " + evenSum + "입니다.");
	}
}




