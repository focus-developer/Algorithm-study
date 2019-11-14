
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5}; //1
//        int[] answers = {1,3,2,4,2}; //1,2,3

        int[] answer = solution(answers);

        for(int an : answer) {
            System.out.println(an);
        }

    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        List<MyCount> answer_list = new ArrayList<>();
        List<Integer> count_sort_list = new ArrayList<>();

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        answer_list.add(new MyCount(1, answerCount(answers, first)));
        answer_list.add(new MyCount(2, answerCount(answers, second)));
        answer_list.add(new MyCount(3, answerCount(answers, third)));

        Collections.sort(answer_list, new Comparator<MyCount>() {
            @Override
            public int compare(MyCount o1, MyCount o2) {
                return (o2.getValue() < o1.getValue()) ? -1 : ((o2.getValue() == o1.getValue()) ? 0 : 1);
            }
        });

        count_sort_list.add(answer_list.get(0).getKey());

        for(int i=1; i<answer_list.size(); i++) {
            if(answer_list.get(i-1).getValue() == answer_list.get(i).getValue()) {
                count_sort_list.add(answer_list.get(i).getKey());
            } else {
                break;
            }
        }

        answer = new int[count_sort_list.size()];
        for(int i=0; i<count_sort_list.size(); i++) {
            answer[i] = count_sort_list.get(i);
        }

        return answer;
    }

    public static int answerCount(int[] answers, int[] student_answer) {
        int count = 0;

        int i = 0;
        for(int answer : answers) {
            if(i == student_answer.length) i = 0;

            if(answer == student_answer[i]) count++;

            i++;
        }


        return count;
    }

    static class MyCount {
        int key;
        int value;

        public MyCount(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
