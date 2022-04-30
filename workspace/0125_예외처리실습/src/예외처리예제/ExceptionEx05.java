package 예외처리예제;

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
		           at 예외처리예제.ExceptionEx05.main(ExceptionEx05.java:9)
		 */
		
		
		if(str != null) {   //null이 아닌 경우
			String newStr = str.toUpperCase();
			System.out.println(newStr);	  //static String str = "abc"; 면 ABC 출력됨!!
		}else {    //null인 경우
			System.out.println("String is null");
		}	
		//String is null
	}
}
