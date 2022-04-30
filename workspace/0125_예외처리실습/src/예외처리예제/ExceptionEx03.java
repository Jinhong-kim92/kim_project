package 예외처리예제;

public class ExceptionEx03 {

	public static void main(String[] args) {
		try {
			int[] array = new int[4];
			array[5] = 10;
		}catch(Exception e) {
			System.out.println("배열의 크기를 벗어났음!!" + e);
		}		
	}
}
