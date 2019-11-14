import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_04 {
	public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> ascqueue = new PriorityQueue<>(); //오름차순(작->큰)
        PriorityQueue<Integer> desqueue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순(큰->작)
        
        for(int i=0;i<operations.length;i++) {
        	String operation = operations[i];
        	int num = 0;
        	if(operation.startsWith("I")) {
        		num = Integer.parseInt(operation.substring(2));
        		ascqueue.add(num);
        		desqueue.add(num);
        	}else {
        		if(ascqueue.size() != 0) {
        			if(operation.contains("-")) {
            			//최소값 삭제
        				desqueue.remove(ascqueue.poll());
            		}else {
            			//최대값 삭제
            			ascqueue.remove(desqueue.poll());
            		}
        		}
        	}
        }
        
        if(ascqueue.size() != 0) {
        	answer[0] = desqueue.peek();
        	answer[1] = ascqueue.peek();
        }
        
        return answer;
    }
	
	public static void run() {
		//String[] operations = {"I 16","D 1"}; //{0,0}
		String[] operations = {"I 7","I 5","I -5","D -1"}; //{7,5}
		int[] answer = solution(operations);
		
		System.out.println("answer = "+answer[0]+", "+answer[1]);
		
	}
}
