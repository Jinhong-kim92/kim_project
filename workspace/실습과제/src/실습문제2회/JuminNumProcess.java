package �ǽ�����2ȸ;

import java.util.Scanner;

public class JuminNumProcess {

	public static void main(String[] args) {
		//�غ� �ܰ� => ���� ����, �迭 ���� => �޸��� �Ϻ�(�׸�) 
		String junminNum;  //Ű����κ��� �Է��� �ֹι�ȣ ���ڿ� ��ü�� �ּҰ��� ����� ��ü ��������
		
		//�Է� �ܰ�
		System.out.print("�ֹι�ȣ �Է� >>> ");
		Scanner scan = new Scanner(System.in);
		junminNum = scan.next();
		
		//ó�� �ܰ� => ������� ����(if��, switch��, for��, while��, continue, break)
		//logic => �ΰ��� ������ ��� => �־��� ������ ��� �ذ��Ұ����� ���?
		//[�ذ� ��� 1]
		String frontJumin = junminNum.substring(0, 6);
		String backJumin = junminNum.substring(7, 14);
		
		//��� �ܰ�
		System.out.println("�ֹι�ȣ �� 6�ڸ�: " + frontJumin);
		System.out.println("�ֹι�ȣ �� 7 �ڸ�: " + backJumin);
		
		System.out.println();
		
		//[�ذ� ��� 2]
		String[] token = junminNum.split("-"); 
		String frontString = token[0];
		String backString = token[1];
		
		System.out.println("�ֹι�ȣ �� 6�ڸ�: " + frontString);
		System.out.println("�ֹι�ȣ �� 7 �ڸ�: " + backString);
		
		//[�߿�] �ǹ� ���
		// "971025-1054171" => "971025-1******"  => ����ŷ(masking) ó��
		String juminNumMasking = backString.replace(backString.substring(1),"******");
		
		System.out.println("<< �ֹι�ȣ ���ڸ� ����ŷó���ϱ� >>");
		System.out.println(frontString + "-" + juminNumMasking);
	}
}












