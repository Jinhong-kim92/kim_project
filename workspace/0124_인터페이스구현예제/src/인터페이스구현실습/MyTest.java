package �������̽������ǽ�;

public class MyTest {

	public static void main(String[] args) {
		RemoteControl rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.selVolumn(8);
		rc.setMute(true);
		RemoteControl.changeBattery();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.selVolumn(5);
		rc.turnOff();
	}
}




