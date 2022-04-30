package 검색알고리즘예제;

import java.util.Scanner;

public class TwoDimensionSearchEx {

	public static void main(String[] args) {
		String[][] str = {{"1","오수철","남자"},
				          {"2","김연아","여자"},
				          {"3","박태호","남자"},
				          {"4","최인호","남자"}};
		int i;
		String find;
		
		System.out.print("찾고자 하는 이름은? ");
		Scanner scan = new Scanner(System.in);
		find = scan.next();
		
		for(i=0; i<str.length; i++) {
			if(find.equals(str[i][1])) {
				System.out.println("검색결과: "+str[i][0]+" "+str[i][1]+" "+str[i][2]);
				break;
			}
		}
		if(i == str.length) {
			System.out.println(find + "을(를) 찾을 수 없습니다.");
		}
		scan.close();
	}
}



