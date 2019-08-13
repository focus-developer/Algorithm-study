import java.util.PriorityQueue;

public class Heap_01 {

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++) {
        	priorityQueue.add(scoville[i]);
        }
        
        while(priorityQueue.size()>1) {
        	if(priorityQueue.peek()>K)
        		break;
        	
        	priorityQueue.add(priorityQueue.poll()+ priorityQueue.poll()*2);
        	answer++;
        }
        
        if(priorityQueue.peek()<K)
        	answer = -1;
        
        return answer;
    }
	
	public static void run() {
		//int[] scoville = {1,2,3,9,10,12}; int k=7; // 2
		int[] scoville = {1,2}; int k=3; // 1
		
		System.out.println("answer = "+solution(scoville,k));
		
	}
}
