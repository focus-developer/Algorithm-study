import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5}; // Return [2, 1]

        int [] answer = solution(progresses, speeds);

        for(int a : answer) {
            System.out.println(a);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int key;
        int max = 0;
        for(int i=0; i<progresses.length; i++) {
            key = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] > 0) {
                key++;
            }

            if(max < key) {
                max = key;
            }
            if(map.get(max) == null) {
                map.put(max, 1);
            }else {
                map.compute(max, (k, v) -> v+1);
            }
        }

        answer = new int[map.size()];

        int i=0;
        Iterator<Integer> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            Integer key_i = keys.next();

            answer[i++] = map.get(key_i);
        }

        System.out.println(Arrays.toString(map.values().stream().toArray()));

        return answer;
    }
}
