package 연산자예제;

public class OperatorEx01 {
	public static void main(String[] args) {
		/*
		int x = 10;
		//x = x + 1;
		//x += 1;
		x++;		
		System.out.println(x);
		*/
		
		//이항 연산자의 우선순위가 동일할 때는 왼쪽 => 오른쪽으로 연산이 진행된다.
		int result = 100 * 2 / 3 % 5;
		System.out.println(result);	//결과값 1	
		
		int var1 = 10;
		int var2 = 30;
		int var3 = 20;
		
		int result2 = var1 + var2 * var3;
		System.out.println(result2);   //610
		
		int result3 = (var1 + var2) * var3;
		System.out.println(result3);   //800
		
		short a,b,c;
		a = 10;
		b= 20;
		c = (short)(a + b);
		System.out.println(c);   //30
	}
}











