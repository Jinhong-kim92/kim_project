package 상속예제;

//부모 클래스 설계
public class Customer {
	//멤버변수 선언(객체가 가져야할 속성)
	protected int customerID;		//고객 아이디
	protected String customerName;	//고객명
	protected String customerGrade;	//고객등급
	protected int bonusPoint;		//보너스 포인트
	protected double bonusRatio;	//보너스 포인트 적립비율	
	
	//생성자
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "GENERAL";
		bonusRatio = 0.01;	//1%		
	}
	
	//필요 메소드 구현
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 고객 등급은 " + customerGrade + "이며, 보너스포인트는 " 
	                   + bonusPoint + "입니다";
	}

	//멤버변수 하나당 getter, setter 메소드 한쌍식 구현
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}	
}





