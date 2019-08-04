
public class Stack_Queue_06 {
	public static int[] solution(int[] prices) {
        int[] answer = {};
        int size = prices.length;
        answer = new int[size];
        //answer[size-1] = 0;
        
        for(int i=0; i<size-1; i++) {
        	for(int j=i+1; j<size; j++) {
        		answer[i]++;
        		if(prices[i]>prices[j])
        			break;
        	}
        }
        
        return answer;
    }
	
	public static void run() {
		//int[] prices = {1,2,3,2,3};//{4,3,1,1,0}
		int[] prices = {1,2,3,2,1,3};//{5,3,1,1,1,0}
		
		
		int[] answer = solution(prices);
		
		System.out.print("answer = ");
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
