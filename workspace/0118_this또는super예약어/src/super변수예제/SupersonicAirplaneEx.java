package super��������;

public class SupersonicAirplaneEx {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		
		//��ü���� ���� => �޼ҵ� ȣ��
		sa.takeOff();
		sa.fly();	//�ڽ� �޼ҵ� ȣ��
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();   //�ڽ� �޼ҵ� ȣ��
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();   //�ڽ� �޼ҵ� ȣ��
		sa.land();
		
		//[������]
		/*  �ùķ��̼�
		 *  �̷��մϴ�.
			�Ϲ� �����մϴ�.
			������ �����մϴ�.
			�Ϲ� �����մϴ�.
			�����մϴ�.
		 */
	}
}
