import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String [] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7; //return 2

//        int[] scoville = {1, 2};
//        int K = 7; //return -1

        int answer = solution(scoville, K);
        System.out.println(answer);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        int newScoville = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for(int s : scoville) {
            queue.add(s);
        }

        while(queue.size() >= 2) {
            int lowest = queue.peek();
            if(lowest < K ) {
                lowest = queue.poll();
                newScoville = lowest + (queue.poll()*2);
                queue.add(newScoville);
                answer++;
            }else {
                break;
            }
        }
        if(queue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
