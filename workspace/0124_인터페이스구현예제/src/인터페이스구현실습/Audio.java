package �������̽������ǽ�;

public class Audio implements RemoteControl{
	//�ʵ�(�������) ����
	private int volumn; 
	
	@Override
	public void turnOn() {
		System.out.println("Audio�� �մϴ�.");		
	}

	@Override
	public void selVolumn(int volumn) {
		if(volumn > MAX_VOLUMN) {
			this.volumn = RemoteControl.MAX_VOLUMN;
		}else if(volumn < RemoteControl.MIN_VOLUMN) {
			this.volumn = RemoteControl.MIN_VOLUMN;
		}else {
			this.volumn = volumn;
		}
		System.out.println("���� Audio ����: " + this.volumn);			
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio�� ���ϴ�.");		
	}
}


