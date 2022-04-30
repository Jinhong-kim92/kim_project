package 추상클래스설계방법;

//추상 클래스, 부모 클래스 설계
public abstract class Car {
	//추상 메소드 선언
	public abstract void drive();
	public abstract void stop();
	
	//일반 메소드 선언
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	//[중요] 템플릿 메소드 => 디자인 패턴 중의 하나
	//run() 템플릿 메소드는 Car가 어떻게 달려야 하는지를 구현해야 한다. 
	//      => 즉 '실행순서'와 '시나리오'를 정의한 메소드이다.
	final public void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
}





