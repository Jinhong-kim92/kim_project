package 실습문제3회;

class Person {
	//멤버변수는 가능한 private으로 설정
	private String name;
	private int age;
	
	//멤버변수 하나당 getter, setter 메소드를 한쌍식 구현한다.
	/*
	 * setter 메소드 구현 규칙 => 반드시 매개변수를 받아야하고, return 타입이 void이다.
	 * getter 메소드 구현 규칙 => 매개변수를 받지 않고, { } 블록 안에 반드시 return이 있어야 한다.
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }	
}

public class Example02 {
	public static void main(String[] args) {
		Person aPerson = new Person();
		
		//aPerson.name = "홍길동";
		//aPerson.age = 28;
		
		aPerson.setName("홍길동");
		aPerson.setAge(28);
		
		//이름과 나이를 출력하세요
		System.out.println("이름: " + aPerson.getName());
		System.out.println("나이: "  + aPerson.getAge());
	}
}




