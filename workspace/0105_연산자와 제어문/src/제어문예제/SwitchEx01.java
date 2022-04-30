package 제어문예제;

public class SwitchEx01 {

	public static void main(String[] args) {
		char grade = 'A';	//회원의 등급이 'B'등급
		
		switch(grade) {
			case 'A':
			case 'a':
				System.out.println("우수 회원입니다.");
				break;	//[주의]
			case 'B':
			case 'b':
				System.out.println("일반 회원입니다.");
				break;
			default:
				System.out.println("손님입니다.");
		}
	}
}
