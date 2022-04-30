package 정렬알고리즘예제;

/*
 * 선택 정렬(Selection sort) 알고리즘 예제 => 숫자 정렬 시키기
 */
public class SelectionSortEx {
	public static void main(String[] args) {
		int[] num = {30, 10, 20, 50, 40};
		int temp;  //임시 저장 공간
		int n = 5; //배열의 데이터 갯수
		
		//선택 정렬 알고리즘 적용
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println("<<< 정렬된 데이터 출력 >>>");
		for(int k=0; k<n; k++) {
			System.out.print(num[k] + " ");
		}
	}
}




