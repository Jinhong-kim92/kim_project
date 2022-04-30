package 상속예제;

public class CustomerTest {
	
	public static void main(String[] args) {
		Customer customrtHong = new Customer(10010, "홍길동");		
		
		int priceHong = customrtHong.calcPrice(20000);
		System.out.println("상품 결제 금액: " + priceHong + "원");
		System.out.println(customrtHong.showCustomerInfo());
		System.out.println();
		
		VIPCustomer customerSon = new VIPCustomer(10020, "손흥민", 12345);		
		
		int priceSon = customerSon.calcPrice(20000);
		System.out.println(customerSon.showCustomerInfo());		
		System.out.println("할인률 적용 상품 결제 금액: " + priceSon + "원");
		
		int agentID = customerSon.getAgentID();
		System.out.println("VIP 고객 담당 상담원 ID: " + agentID);		
		System.out.println();
		
		GOLDCustomer goldCustomerLee = new GOLDCustomer(10030, "이강인");		
		int priceLee = goldCustomerLee.calcPrice(20000);
		System.out.println(goldCustomerLee.showCustomerInfo());
		System.out.println("할인률 적용 상품 결제 금액: " + priceLee + "원");
	}
}





