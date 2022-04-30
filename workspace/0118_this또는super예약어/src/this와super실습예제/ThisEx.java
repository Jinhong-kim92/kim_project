package this와super실습예제;

class Person {
	//속성, 멤버변수(=인스턴스변수)
	private int juminNum;	//주민번호
	private int militaryNum;	//군번
	private int birthYear;	//출생년도
	private int birthMonth;	//출생월
	private int birthDay;	//출생일
	
	//생성자 => 군번이 있는 경우
	public Person(int juminNum, int militaryNum, int bYear, int bMonth, int bDay) {
		this.juminNum = juminNum;	//멤버변수 초기화
		this.militaryNum = militaryNum;
		birthYear = bYear;
		birthMonth = bMonth;
		birthDay = bDay;
	}
	
	//생성자 => 군번이 없는 경우
	public Person(int juminNum, int bYear, int bMonth, int bDay) {
		this(juminNum, 0, bYear, bMonth, bDay);
		
		/*
		this.juminNum = juminNum;
		this.militaryNum = 0;
		birthYear = bYear;
		birthMonth = bMonth;
		birthDay = bDay;
		*/
	}
	
	//필요한 메소드 구현
	public void showInfo() {
		System.out.println("주민번호: " + juminNum);
		System.out.println("생년월일: " + birthYear+"/"+birthMonth+"/"+birthDay);
		
		if(militaryNum != 0) {
			System.out.println("군번: " + militaryNum + '\n');
		}else {
			System.out.println("군과 관계없음!");
		}		
	}
}

public class ThisEx {
	public static void main(String[] args) {
		Person man = new Person(951024, 880102, 1995, 10, 24);
		Person woman = new Person(991126, 1999, 11, 26);
		
		man.showInfo();
		woman.showInfo();
	}
}




