package ��ӿ���;

public class CustomerTest {
	
	public static void main(String[] args) {
		Customer customrtHong = new Customer(10010, "ȫ�浿");		
		
		int priceHong = customrtHong.calcPrice(20000);
		System.out.println("��ǰ ���� �ݾ�: " + priceHong + "��");
		System.out.println(customrtHong.showCustomerInfo());
		System.out.println();
		
		VIPCustomer customerSon = new VIPCustomer(10020, "�����", 12345);		
		
		int priceSon = customerSon.calcPrice(20000);
		System.out.println(customerSon.showCustomerInfo());		
		System.out.println("���η� ���� ��ǰ ���� �ݾ�: " + priceSon + "��");
		
		int agentID = customerSon.getAgentID();
		System.out.println("VIP �� ��� ���� ID: " + agentID);		
		System.out.println();
		
		GOLDCustomer goldCustomerLee = new GOLDCustomer(10030, "�̰���");		
		int priceLee = goldCustomerLee.calcPrice(20000);
		System.out.println(goldCustomerLee.showCustomerInfo());
		System.out.println("���η� ���� ��ǰ ���� �ݾ�: " + priceLee + "��");
	}
}





