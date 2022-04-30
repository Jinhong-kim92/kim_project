package 검색알고리즘예제;

import java.util.Scanner;

public class SequenceStringSearchEx {

	public static void main(String[] args) {
		String[] name = {"오수철","김선동","이강인","손흥민","박태호"};
		int i;
		String find;
		
		System.out.print("찾고자 하는 이름은? ");
		Scanner scan = new Scanner(System.in);
		find = scan.next();
		
		for(i=0; i<name.length; i++) {
			if(find.equals(name[i])) {
				System.out.println("찾고자 하는 이름은 " + name[i] + "입니다.");
				break;
			}
		}
		if(i == name.length) {
			System.out.println(find + "을(를) 찾을 수 없습니다.");
		}
		scan.close();
	}
}




