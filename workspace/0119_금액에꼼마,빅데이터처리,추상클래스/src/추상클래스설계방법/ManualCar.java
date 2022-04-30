package 추상클래스설계방법;

//일반 클래스, 자식 클래스, 실체클래스
public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("운전자가 운전합니다.");
		System.out.println("운전자가 핸들을 조작합니다.");
	}

	@Override
	public void stop() {
		System.out.println("운전자가 브레이크로 정지합니다.");		
	}
}
