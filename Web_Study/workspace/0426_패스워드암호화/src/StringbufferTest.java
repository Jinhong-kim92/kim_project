/**
 * 
 * String 클래스 객체와 StringBuffer 클래스 객체의 차이점
 *
 */
public class StringbufferTest {
	public static void main(String[] args) {
		String string_data_var = "ABC";
		System.out.println(System.identityHashCode(string_data_var));
		//366712642 메모리 주소값 => "ABC" 스트링객체의 주소값
		
		string_data_var += "DEF";
		System.out.println(System.identityHashCode(string_data_var));
		//1829164700
		
		StringBuffer sb_data_var = new StringBuffer();
		sb_data_var.append("ABC");
		System.out.println(System.identityHashCode(sb_data_var));
		//2018699554
		
		sb_data_var.append("DEF");
		System.out.println(System.identityHashCode(sb_data_var));
		//2018699554
	}

}
