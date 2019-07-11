import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Etc_01 {
	public static void main(String[] args) {
		//int[] v = {1,2,3,3,3,4,4};
        //int[] v = {3,2,4,4,2,5,2,5,5};
        //int[] v = {3,5,7,9,1};
        int[] v = {5,5,5,5,1,10,10,20,1};

        int[] answer = solution(v);

        for(int i=0;i<answer.length;i++)
            System.out.print(answer[i]+" ");
        System.out.println("");
	}
	
	public static int[] solution(int[] param){
        int[] answer = {};
        HashMap<Integer,Integer> count = new HashMap<>();

        for(int i=0;i<param.length;i++){
            if(count.get(param[i]) == null){
                count.put(param[i],1);
            }
            else{
                int tmp = count.get(param[i])+1;
                count.put(param[i],tmp);
            }
        }

        TreeMap<Integer,Integer> sortedMap = new TreeMap<>(count);
        Iterator<Integer> sortedMapIterator = sortedMap.keySet().iterator();
        int overlapCount = 0;
        HashMap<Integer,Integer> overlapSave = new HashMap<>();
        while(sortedMapIterator.hasNext()){
            Integer key = sortedMapIterator.next();
            if(sortedMap.get(key)>1) {
                overlapCount++;
                overlapSave.put(overlapCount,sortedMap.get(key));
            }
        }

        if(overlapCount==0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else {
            answer = new int[overlapCount];
            Iterator<Integer> overlapSaveIterator = overlapSave.keySet().iterator();

            while(overlapSaveIterator.hasNext()){
                Integer key = overlapSaveIterator.next();
                answer[key-1] = overlapSave.get(key);
            }

            return answer;
        }

    }

}
