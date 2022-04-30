package 폰추상클래스설계;

public class SmartPhone extends Phone {

	//생성자
	public SmartPhone(String owner) {
		super(owner);		
	}
	
	//자식 클래스 메소드 구현
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
