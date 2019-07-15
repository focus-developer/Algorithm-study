import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"}; //4,1,3,0
        int[] plays = {500, 600, 150, 800, 2500};

//        String[] genres = {"classic", "pop", "k-pop", "classic", "classic", "pop"}; // 1, 5, 4, 0, 2
//        int[] plays = {500, 2500, 400, 150, 800, 2500};

        int[] answer = solution(genres, plays);

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        int size = 0;

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map_check = new HashMap<>();


        for(int i=0; i<genres.length; i++){
            if(map.get(genres[i]) == null) {
                map.put(genres[i], plays[i]);
                map_check.put(genres[i], 1);
            }else {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                map_check.put(genres[i], map_check.get(genres[i]) + 1);
            }
        }

        Iterator<String> keys = map_check.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();

            if(map_check.get(key) >= 2) {
                size += 2;
            }else if(map_check.get(key) == 1) {
                size++;
            }
        }

        answer = new int[size];

        int k=0;
        Iterator it = sortByValue(map).iterator();
        while(it.hasNext()) {
            String key = (String) it.next();

            int max = 0;
            int maxIndex = 0;
            for(int i=0; i<genres.length; i++) {
                if(key.equals(genres[i])) {
                    if(max < plays[i]) {
                        max = plays[i];
                        maxIndex = i;
                    }
                }
            }

            answer[k++] = maxIndex;
            plays[maxIndex] = 0;

            max = 0;
            maxIndex = 0;

            if(map_check.get(key) > 1) {
                for (int i = 0; i < genres.length; i++) {
                    if (key.equals(genres[i])) {
                        if (max < plays[i]) {
                            max = plays[i];
                            maxIndex = i;
                        }
                    }
                }
                answer[k++] = maxIndex;
                plays[maxIndex] = 0;
            }



        }

        return answer;
    }

    public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();

        list.addAll(map.keySet());



        Collections.sort(list,new Comparator() {

            public int compare(Object o1,Object o2) {

                Object v1 = map.get(o1);

                Object v2 = map.get(o2);



                return ((Comparable) v2).compareTo(v1);

            }

        });



//        Collections.reverse(list); // 주석시 오름차순

        return list;

    }
}
