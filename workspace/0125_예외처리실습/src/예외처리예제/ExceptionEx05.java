package ����ó������;

public class ExceptionEx05 {

	static String str;
	//static String str = "abc";
	
	public static void main(String[] args) {		
		/*
		String newStr = str.toUpperCase();
		System.out.println(newStr);		
		System.out.println("String is null");
		*/
		/*
		 * Exception in thread "main" java.lang.NullPointerException
		           at ����ó������.ExceptionEx05.main(ExceptionEx05.java:9)
		 */
		
		
		if(str != null) {   //null�� �ƴ� ���
			String newStr = str.toUpperCase();
			System.out.println(newStr);	  //static String str = "abc"; �� ABC ��µ�!!
		}else {    //null�� ���
			System.out.println("String is null");
		}	
		//String is null
	}
}
