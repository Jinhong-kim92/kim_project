package 추상클래스설계방법;

//실행 클래스
public class CarTest {
	public static void main(String[] args) {
		System.out.println("<<< 자율 주행 지동차 >>>");
		
		//객체 생성
		Car myCar = new AICar();
		myCar.run();
		
		System.out.println();
		
		System.out.println("<<< 사람이 운전하는 일반 지동차 >>>");
		Car hisCar = new ManualCar();
		hisCar.run();
	}
}
