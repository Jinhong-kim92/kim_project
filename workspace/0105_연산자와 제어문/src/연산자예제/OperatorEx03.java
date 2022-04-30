package 연산자예제;

public class OperatorEx03 {

	public static void main(String[] args) {
		String strVar1 = "박태호";
		String strVar2 = "박태호";
		
		String strVar3 = new String("박태호");
		
		System.out.println(strVar1 == strVar2);   //ture
		System.out.println(strVar1 == strVar3);	  //false
		
		System.out.println(strVar1.equals(strVar2));   //true
		System.out.println(strVar1.equals(strVar3));   //true
	}
}





