package �ǽ�����1ȸ;

import java.util.Scanner;

public class CaseChanger {

	public static void main(String[] args) {
		//�غ� �ܰ�
		char alpha;
		
		//�Է� �ܰ�
		System.out.print("���� �� �ڸ� �Է��ϼ��� >>> ");
		Scanner scan = new Scanner(System.in);
		/*
		 * 'A' => 65
		 * "A" => "A\0"
		 */
		alpha = scan.next().charAt(0);
		
		if(alpha >= 'a' && alpha <= 'z') { //&& AND ������,    || OR ������
			//�º� = �캯;
			alpha = (char) (alpha - 32);
		}else if(alpha >= 'A' && alpha <= 'Z') { //&& AND ������,    || OR ������			
			alpha = (char) (alpha + 32);
		}else { //�ѱ��� �Էµ� ���
			System.out.println("�����ڰ� �ƴմϴ�.");
			System.exit(0);   //���α׷� ���� ����
		}
		System.out.println(alpha);
		scan.close();
	}
}









