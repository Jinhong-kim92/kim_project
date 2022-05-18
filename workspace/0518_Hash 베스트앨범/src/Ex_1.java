import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();
        int[] answer;

        for(int i = 0; i< genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        List<String> list = new ArrayList<>(map.keySet());

        list.sort((value1, value2) -> (map.get(value2)).compareTo(map.get(value1)));


        for(String s : list){
            int fir = 0;
            int sec = 0;
            int max = 0;

            // 첫번째 값 찾기
            for(int i = 0; i< genres.length;i++){
                if(s.equals(genres[i])){
                    if(plays[i]>max){
                        max = plays[i];
                        fir = i;
                    }
                }
            }
            max = 0;
            //두번째 값 찾기
            for(int i = 0; i< genres.length;i++){
                if(s.equals(genres[i])){
                    if(i != fir && plays[i]>max){
                        max = plays[i];
                        sec = i;
                    }
                }
            }

            tmp.add(fir);
            //주의!!
            if(max != 0) {
                tmp.add(sec);
            }
        }

        answer = new int[tmp.size()];

        for(int i = 0; i< tmp.size();i++){
            answer[i] = tmp.get(i);
        }


        return answer;
    }
}



public class Ex_1 {

	public static void main(String[] args) {
		
		String [] genres = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays = {500, 600, 150, 800, 2500};
		Solution sol  = new Solution();
		System.out.println(Arrays.toString(sol.solution(genres, plays)));
		
 
	}

}
