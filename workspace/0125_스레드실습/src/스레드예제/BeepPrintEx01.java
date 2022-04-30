package 스레드예제;

import java.awt.Toolkit;

/*
 * 스레드(Thread)란?
 *    => 동작하고 있는(실행 중인) 프로그램을 프로세스(process)라고 한다.
 *       보통 한 개의 프로세스는 한 가지의 일을 하지만, 스레드를 이용하면 한 프로세스 내에서
 *       두 가지 또는 그 이상의 일을 동시에 할 수 있다.
 * 모든 자바 애플리케이션은 main 스레드가 main() 메소드를 실행하면서 시작된다.
 *       
 * 이번 예제는 싱글 스레드(하나의 스레드, main 스레드)가 처리한것이다.
 */

public class BeepPrintEx01 {
	public static void main(String[] args) {
		//Toolkit 객체 생성
		/*
		 * Toolkit 클래스는 "시스템 정보"를 얻는 것으로 시스템 자원에 
		 * 접근 할 수 있는 클래스이다.
		 */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++) {
			toolkit.beep();  //beep()는 비프음을 발생시키는 메소드
			try {
				Thread.sleep(1000);  //1초간 cpu작동을 멈추는것 즉 1초 간격으로 비프임을 울려라
			}catch(Exception e) {
				System.out.println(e);
			}
		}
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
