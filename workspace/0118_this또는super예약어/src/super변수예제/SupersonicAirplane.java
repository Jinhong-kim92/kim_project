package super변수예제;

public class SupersonicAirplane extends Airplane{
	//상수 선언 => 자주 사용하는 고정값들은 상수를 사용함으로써 가독성을 높여준다.
	public static final int NORMAL = 1;   	  //일반 비행
	public static final int SUPERSONIC = 2;   //초음속 비행
	
	//멤버 변수 선언
	public int flyMode = NORMAL;
	
	@Override //메소드 오버라이딩 => 다형성을 구현하기 위한 개념
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		}else {
			super.fly();  //부모 클래스의 fly() 메소드 호출하겠다 의미
		}
	}	
}
