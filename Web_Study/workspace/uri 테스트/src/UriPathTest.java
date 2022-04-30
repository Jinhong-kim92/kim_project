
public class UriPathTest {

	public static void main(String[] args) {
		String uri = "/Model2_Board/login.do";
		
		//int lastPosition = uri.lastIndexOf("/");
		//System.out.println(lastPosition);  //13 출력
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);   // "/login.do" 출력됨!!
	}
}
