package 스트림응용_학생평균점수구하기;

public class Student {
	//멤버변수 선언
	private String name;	//이름
	private int score;		//점수
	
	//생성자
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	//멤버변수 하나당 getter 메소드
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}	
}
