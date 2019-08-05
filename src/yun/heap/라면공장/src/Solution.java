import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30; // return 2

//        int stock = 4;
//        int[] dates = {1, 2, 3, 4};
//        int[] supplies = {10, 40, 30, 20};
//        int k = 100; // return 4

        int answer = solution(stock, dates, supplies, k);
        System.out.println(answer);
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int date_index = 0;
        for (int i = 0; i < k; i++) {
            if (date_index < dates.length && i == dates[date_index]) {
                queue.add(supplies[date_index++]);
            }
            if (stock == 0) {
                stock += queue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }


}
