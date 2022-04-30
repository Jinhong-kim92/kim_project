package 정렬알고리즘예제;

public class Selection2DimensionSort {

	public static void main(String[] args) {
		String[][] str = {{"1","박태호","서울","프로그래머"},
				          {"2","김선동","인천","회사원"},
				          {"3","오수철","분당","연예인"},
				          {"4","손유일","강남","변호사"}};
		String temp;
		
		//"이름" 순으로 정렬하자!!
		for(int i=0; i<str.length-1; i++) {
			for(int j=i+1; j<str.length; j++) {
				if(str[i][1].compareTo(str[j][1]) > 0) {
					for(int k=0; k<str[0].length; k++) {
						temp = str[i][k];
						str[i][k] = str[j][k];
						str[j][k] = temp;
					}
				}
			}
		}
		//출력
		for(int m=0; m<str.length; m++) {
			for(int s=0; s<str[0].length; s++) {
				System.out.print(str[m][s] + " ");
			}
			System.out.println();
		}
	}
}





