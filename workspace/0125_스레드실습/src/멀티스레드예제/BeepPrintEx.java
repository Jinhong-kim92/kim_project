package 멀티스레드예제;

public class BeepPrintEx {

	public static void main(String[] args) {
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);  //작업 스레드 객체 생성		
		thread.start();  //이 시점에서 작업 스레드 작동 
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
