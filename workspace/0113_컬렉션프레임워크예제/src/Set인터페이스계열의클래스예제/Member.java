package Set인터페이스계열의클래스예제;

//          자식클래스  extends  부모클래스 
public class Member {
	//멤버 변수(=인스턴스 변수)
	public String name;		//이름
	public int age;			//나이
	public String juminNum;	//주민번호
	
	//생성자                         매개변수(parameter)
	public Member(String name, int age, String juminNum) {
		this.name = name;
		this.age = age;
		this.juminNum = juminNum;		
	}
	
	//부모 클래스의 메소드를 수동으로 오버라이드 시키는 방법 
	//=> 먼저 e를 입력하고 Ctrl + spacebar 동시에 누르면 메소드가 뜬다. 더블 클릭한다.
	@Override   //어노테이션 => 재사용 개념 => 다형성 개념 포함
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age)
					&& member.juminNum.equals(juminNum);			
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {		
		return name.hashCode() + age + juminNum.hashCode();
	}
}




