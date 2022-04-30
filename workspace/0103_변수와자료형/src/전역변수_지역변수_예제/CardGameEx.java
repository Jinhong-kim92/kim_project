package 전역변수_지역변수_예제;

/*
 * 자바의 클래스 변수와 인스턴스 변수를 이해하기 좋은 예제 프로그램
 */
class Card {
	static int width = 100;   //넓이 클래스 변수
	static int height = 250;  //높이 클래스 변수
	
	String kind;  //카드 마다 고유 무뉘의 종류 인스턴스 변수    
	int number;   //카드 마다 고유 숫자의 인스턴스 변수
}

public class CardGameEx {
	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		Card card1 = new Card();  //Card라는 인스턴스 객체가 생성
		card1.kind = "Spade";
		card1.number = 5;
		
		Card card2 = new Card();
		card2.kind = "Heart";
		card2.number = 8;
		
		System.out.println("card1은 " + card1.kind+","+card1.number+"이며,"
				+ "카드 크기는("+card1.width+","+card1.height+")");

		System.out.println("card2은 " + card2.kind+","+card2.number+"이며,"
				+ "카드 크기는("+card2.width+","+card2.height+")");
	}

}




