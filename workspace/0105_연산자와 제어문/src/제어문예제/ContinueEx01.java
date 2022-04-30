package 제어문예제;

/*
 * 1부터 10까지 중에서 짝수만 출력하기 => 2 4 6 8 10만 출력
 */

public class ContinueEx01 {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {	//i값이 홀수값이면
				continue;   //[중요]
			}
			System.out.print(i + " ");
		}
	}
}
