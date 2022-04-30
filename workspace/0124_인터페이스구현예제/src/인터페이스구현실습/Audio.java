package 인터페이스구현실습;

public class Audio implements RemoteControl{
	//필드(멤버변수) 선언
	private int volumn; 
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");		
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
		System.out.println("현재 Audio 볼륨: " + this.volumn);			
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");		
	}
}


