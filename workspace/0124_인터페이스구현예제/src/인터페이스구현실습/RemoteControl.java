package �������̽������ǽ�;

public interface RemoteControl {
	//��� ����
	public static final int MAX_VOLUMN = 10;	//�ִ� ����
	public static final int MIN_VOLUMN = 1;		//�ּ� ����
	
	//�߻� �޼ҵ� ����
	public abstract void turnOn();	 			//�Ҵ�
	public abstract void turnOff();  			//����
	public abstract void selVolumn(int volumn);	//���� ����
	
	/*
	 * �ڹ� 8�������ʹ� ����Ʈ �޼ҵ�� ���� �޼ҵ� ������ ����������. 
	 *   => ������ ���忡�� ������ �������� ����!!
	 */
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó���մϴ�.");
		}else {
			System.out.println("���� �����մϴ�.");
		}
	}
	/*
	 * ���� �޼ҵ� => ����Ʈ �޼ҵ�ʹ� �޸� ��ü�� ��� �������̽������� ȣ���� �����ϴ�.
	 */
	static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	}	
}






