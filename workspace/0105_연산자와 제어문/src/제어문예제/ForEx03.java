package �������;

/*
 * 1���� 100������ ¦���� ���� ���ϴ� ���α׷� �ۼ�
 */

public class ForEx03 {
	public static void main(String[] args) {
		int evenSum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%2 != 0) {
				evenSum = evenSum + i;
			}
		}
		System.out.println("1���� 100������ ¦�������� " + evenSum + "�Դϴ�.");
	}
}




