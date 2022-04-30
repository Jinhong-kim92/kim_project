package super변수예제;

public class SupersonicAirplaneEx {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		
		//객체에게 동작 => 메소드 호출
		sa.takeOff();
		sa.fly();	//자식 메소드 호출
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();   //자식 메소드 호출
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();   //자식 메소드 호출
		sa.land();
		
		//[실행결과]
		/*  시뮬레이션
		 *  이륙합니다.
			일반 비행합니다.
			초음속 비행합니다.
			일반 비행합니다.
			착륙합니다.
		 */
	}
}
