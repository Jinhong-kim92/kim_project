package this와super실습예제;

class Man {		//부모 클래스
	//멤버변수
	String name;	//이름
	
	//디폴트 생성자
	public Man() {}
	
	//생성자
	public Man(String name) {
		this.name = name;
	}
	
	//필요한 메소드 구현
	public void tellYourName() {
		System.out.println("My name is " + name);
	}	
}

//자식 클래스
class BusinessMan extends Man {
	//멤버변수
	String company;		//회사명
	String position;	//직급
	
	//생성자
	public BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
	}
	
	//필요한 메소드 구현
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
	}	
}

public class SuperEx {
	public static void main(String[] args) {
		BusinessMan man1 = new BusinessMan("오수철", "삼성전자", "부장");
		BusinessMan man2 = new BusinessMan("박태호", "LG전자", "과장");

		System.out.println("First man info =>");
		man1.tellYourName();
		man1.tellYourInfo();
		
		System.out.println();
		
		System.out.println("Second man info =>");
		man2.tellYourName();
		man2.tellYourInfo();
	}
}





