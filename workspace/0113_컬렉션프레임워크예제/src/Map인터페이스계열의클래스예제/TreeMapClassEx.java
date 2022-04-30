package Map인터페이스계열의클래스예제;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapClassEx {

	public static void main(String[] args) {
		//TreeMap 객체 생성
		Map<Integer, String> testMap = new TreeMap<Integer, String>();
		
		testMap.put(1, "apple");
		testMap.put(5, "pineapple");
		testMap.put(2, "orange");
		testMap.put(3, "strawberry");
		testMap.put(4, "melon");
		
		//System.out.println(testMap);
		//{1=apple, 2=orange, 3=strawberry, 4=melon, 5=pineapple}
		
		Iterator<Integer> it = testMap.keySet().iterator();  //오름차순
		
		//내림차순 정렬
		//Iterator<Integer> it 
		//    = ((TreeMap<Integer, String>) testMap).descendingKeySet().iterator(); 
		
		while(it.hasNext()) {
			int key = it.next();
			System.out.println(key + "\t" + testMap.get(key));
		}
	}
}





