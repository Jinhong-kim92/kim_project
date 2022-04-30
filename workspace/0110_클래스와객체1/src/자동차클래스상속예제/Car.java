package 자동차클래스상속예제;
/*
 * Car 클래스 => 부모 클래스 역할
 */
public class Car {
		//객체가 가져야할 속성 => 멤버 변수
		protected int speed;	   //현재속도
		protected int wheelNum;	   //바퀴의 수
		protected String carName;  //자동차이름
		
		//디폴트(default) 생성자 생성
		public Car() {
			
		}
		//생성자1
		public Car(String name) {
			carName = name;
		}
		//생성자2
		public Car(int velocity) {
			speed = velocity;
		}
		//생성자3
		public Car(String name, int velocity) {
			carName = name;
			speed = velocity;
		}
		//메소드 구현
		public void speedUp() {
			speed = speed + 1;
		}
		
		public void speedUp(int velocity) {
			speed = speed + velocity;
		}
		
		public void speedDown() {
			speed = speed - 1;
		}
		
		public void stop() {
			speed = 0;
		}
}
