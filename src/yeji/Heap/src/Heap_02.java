import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_02 {
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int index = 0;
        for(int today=0;today<k;today++) {
        	if(index<dates.length && dates[index]==today) {
        		queue.add(supplies[index]);
        		index++;
        	}
        	if(stock==0) {
        		stock += queue.poll();
        		answer++;
        	}
        	stock--;
        }
        
        return answer;
    }

	
	public static void run() {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		// 2
		
		// 4, [1, 2, 3, 4], [10, 40, 30, 20], 100  return 값 4
		
		
		System.out.println("answer = "+solution(stock,dates,supplies,k));
		
	}
	
}
