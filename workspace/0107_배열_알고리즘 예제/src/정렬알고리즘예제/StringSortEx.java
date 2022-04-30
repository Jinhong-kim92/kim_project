package 정렬알고리즘예제;






public class StringSortEx {
	public static void main(String[] args) {
		//준비 단계 => 변수 선언, 배열선 선언 => 그릇(저장공간)을 준비 및 초기화
		String[] name = {"박태호","김선동","오수철","손유일"};
		String temp;
		int n = 4;
		
		//처리 단계 => 선택정렬 알고리즘 적용
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(name[i].compareTo(name[j]) > 0) {
					temp = name[i];
					name[i] = name[j];
					name[j] = temp;
				}
			}
		}
		//출력 단계
		System.out.println("<<< 정렬된 문자열 >>>");
		
		for(int k=0; k<n; k++) {
			System.out.print(name[k] + " ");
		}
	}
}









