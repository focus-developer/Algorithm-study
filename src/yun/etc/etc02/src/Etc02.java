
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Etc02 {
    public static void main(String[] args) {
        // write your code here


        int [] arr1 = {1,2,2,3,2,2,2};
        int [] arr2 = {4,5,4,5,4,5,4};


        int answer = solution(arr1, arr2);
        System.out.println(answer);

    }

    public static int solution(int [] arr1, int [] arr2) {
        int answer = 0;

        Map<Integer, Integer> map1 = toMap(arr1);
        Map<Integer, Integer> map2 = toMap(arr2);

        answer = answer(map1, map2);

        return answer;
    }

    public static Map<Integer, Integer> toMap(int [] arr) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


        for(int i=0; i<arr.length; i++) {
            if(map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            }else {
                map.put(arr[i], map.get(arr[i])+1);
            }

        }


        return map;
    }

    public static int answer(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {

        int answer = 0;

        int key1 = 0;
        int key2 = 0;

        int maxKey1 = 0;
        int maxKey2 = 0;

        int max1 = 0;
        int max2 = 0;

        Iterator<Integer> keys1 = map1.keySet().iterator();
        Iterator<Integer> keys2 = map2.keySet().iterator();
        while(keys1.hasNext() && keys2.hasNext()) {
            key1 = keys1.next();
            key2 = keys2.next();


            if(max1 <= map1.get(key1) && key1 > maxKey1) {
                max1 = map1.get(key1);
                maxKey1 = key1;
            }

            if(max2 <= map2.get(key2) && key2 > maxKey2) {
                max2 = map2.get(key2);
                maxKey2 = key2;
            }



        }

        if(max1 == 1 && max2 == 1) {
            answer = 0;
        }else if(max1 < max2) {
            if(max1 >= 4 && max2 >= 5) {
                answer = findWinner(maxKey1, maxKey2);
            }else {
                answer = 2;
            }
            answer = 2;
        }else if(max1 > max2) {
            if(max1 >= 5 && max2 >= 4) {
                answer = findWinner(maxKey1, maxKey2);
            }else {
                answer = 1;
            }
        }else if(max1 == max2) {
            answer = findWinner(maxKey1, maxKey2);
        }

        return answer;
    }

    public static int findWinner(int maxKey1, int maxKey2) {
        int answer = 0;

        if(maxKey1 > maxKey2) {
            answer = 1;
        }else if(maxKey1 < maxKey2) {
            answer = 2;
        }else {
            answer = 0;
        }

        return answer;

    }

}
