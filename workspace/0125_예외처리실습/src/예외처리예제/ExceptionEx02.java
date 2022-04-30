package 예외처리예제;

public class ExceptionEx02 {
	public static void main(String[] args) {
		int a;
		int b;
		
		try {
			a = 0;
			b = 10 / a;		
			System.out.println("잘 나누어집니다.");
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");
	}
}
