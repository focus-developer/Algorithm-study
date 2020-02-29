import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // return 4

//        String[] words = {"hot", "dot", "dog", "lot", "log"}; // return 0


        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {

        boolean check = false;

        for(int i=0; i<words.length; i++) {
            if(target.equals(words[i])) {
                check = true;
                break;
            }
        }

        if(!check) {
            return 0;
        }

        List<String> wordsList = new ArrayList<>();
        wordsList.add(target);
        for(int i=0; i<words.length && !words.equals(target); i++) {
            wordsList.add(words[i]);
        }

        return DFS(0, begin, target, wordsList);
    }

    public static int DFS(int count, String begin, String target, List<String> wordsList) {

        if(begin.equals(target)) {
            return count;
        }

        String[] begins = begin.split("");

        for (int i=0; i<wordsList.size(); i++) {
            int sum = 0;

            String[] wordss = wordsList.get(i).split("");

            for(int j=0; j<begins.length; j++) {
                if(begins[j].equals(wordss[j])) {
                    sum++;
                }
            }

            if(sum == begins.length-1) {
                begin = wordsList.get(i);
                wordsList.remove(i);
                break;
            }
        }
        count = count + 1;

        return DFS(count, begin, target, wordsList);
    }
}
