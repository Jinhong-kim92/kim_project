package 폰추상클래스설계;

public class TelePhone extends Phone{

	public TelePhone(String owner) {
		super(owner);		
	}
	
	//자식 클래스 메소드 구현
	public void autoAnswering() {
		System.out.println("자동 응답을 합니다.");
	}
}
