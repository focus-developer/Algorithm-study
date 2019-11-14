import java.util.HashMap;
import java.util.Iterator;

public class Hash_03 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(int i=0;i<clothes.length;i++) {
        	String key = clothes[i][1];
        	if(clothesMap.get(key)==null)
        		clothesMap.put(key, 1);
        	else
        		clothesMap.compute(key, (k, v)-> v+1);
        }
        
        Iterator iterator = clothesMap.keySet().iterator();
        while(iterator.hasNext()) {
        	String key = (String) iterator.next();
        	answer *= clothesMap.get(key)+1 ;
        }
        
        return answer-1;
    }
	
	public static void run() {
		//String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; //5
		//String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; //3
		//String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; //11
		String[][] clothes = {{"f1", "face"}, {"f2", "face"},{"f3", "face"}, {"e1", "eyewear"},{"e2", "eyewear"}, {"h1", "headgear"}}; //23
		
		System.out.println("answer = "+solution(clothes));
	}

}
