package 상속예제;

public class GOLDCustomer extends Customer{
	//멤버변수
	private double saleRatio;	//할인률

	//생성자
	public GOLDCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "GOLD";	//고객등급
		bonusRatio = 0.02;		//보너스 적립 2%
		saleRatio = 0.1;		//할인률 10%		
	}
	
	//필요한 메소드 구현
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);  //할인률 적용
	}
}





