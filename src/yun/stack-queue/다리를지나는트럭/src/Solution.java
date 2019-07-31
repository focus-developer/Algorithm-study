import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7, 4, 5, 6}; // return 8

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10}; // return 101

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10,10, 10}; // return 110

        int answer = solution(bridge_length, weight, truck_weights);
        System.out.println("answer = " + answer);

    }



    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int truck_weights_sum = 0;

        for(int i=0; i<truck_weights.length; i++) {
            truck_weights_sum += truck_weights[i];
                if(queue.size() == bridge_length) {
                    truck_weights_sum -= queue.peek();
                    ((LinkedList<Integer>) queue).pop();
                }
                if(truck_weights_sum <= weight) {
                    queue.add(truck_weights[i]);
                    answer++;
                }
                else {
                    queue.add(0);
                    truck_weights_sum -= truck_weights[i];
                    i--;
                    answer++;
                }
        }

        answer += bridge_length;



        return answer;
    }
}
