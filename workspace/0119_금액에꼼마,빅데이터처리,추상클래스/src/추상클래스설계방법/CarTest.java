package �߻�Ŭ����������;

//���� Ŭ����
public class CarTest {
	public static void main(String[] args) {
		System.out.println("<<< ���� ���� ������ >>>");
		
		//��ü ����
		Car myCar = new AICar();
		myCar.run();
		
		System.out.println();
		
		System.out.println("<<< ����� �����ϴ� �Ϲ� ������ >>>");
		Car hisCar = new ManualCar();
		hisCar.run();
	}
}
