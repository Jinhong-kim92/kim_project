package 인터페이스구현실습;

public interface RemoteControl {
	//상수 선언
	public static final int MAX_VOLUMN = 10;	//최대 볼륨
	public static final int MIN_VOLUMN = 1;		//최소 볼륨
	
	//추상 메소드 선언
	public abstract void turnOn();	 			//켠다
	public abstract void turnOff();  			//끈다
	public abstract void selVolumn(int volumn);	//볼륨 조절
	
	/*
	 * 자바 8버전부터는 디폴트 메소드와 정적 메소드 선언이 가능해졌다. 
	 *   => 개발자 입장에서 개발의 유연성이 생김!!
	 */
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	/*
	 * 정적 메소드 => 디폴트 메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능하다.
	 */
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}	
}






