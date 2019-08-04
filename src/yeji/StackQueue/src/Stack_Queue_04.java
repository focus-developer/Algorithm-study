import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_04 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int currentWeight = 0;
        
        for(int i=0;i<truck_weights.length;i++) {
        	if(queue.size()==bridge_length) {
        		currentWeight -= queue.peek();
        		queue.poll();
        	}
        	
        	if( (currentWeight+truck_weights[i]) <= weight) {
        		currentWeight += truck_weights[i];
        		queue.add(truck_weights[i]);
        		answer++;
        	}else {
        		queue.add(0);
        		i--;
        		answer++;
        	}
        }
        
        answer += bridge_length;
        
        return answer;
    }
	
	public static void run() {
		int bridge_length = 2; int weight = 10; int[] truck_weights = {7,4,5,6}; //8
		//int bridge_length = 100; int weight = 100; int[] truck_weights = {10}; //101
		//int bridge_length = 100; int weight = 100; int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; //110
		
		System.out.println("answer = "+solution(bridge_length, weight, truck_weights));
	}
}
