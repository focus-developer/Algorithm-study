
public class Stack_Queue_02 {
	public static int[] solution(int[] heights) {
        int[] answer = {};
        int size = heights.length;
        answer = new int[size];

        for(int i=0;i<size;i++) {
        	answer[i] = 0;
        }
        
        for(int i=size-1; i>0; i--) {
        	for(int j=i-1;j>-1;j--) {
        		if(heights[i]<heights[j]) {
        			answer[i] = j+1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void run() {
		//int[] heights = {6,9,5,7,4}; // [0,0,2,2,4]
		//int[] heights = {3,9,9,3,5,7,2}; // [0,0,0,3,3,3,6]
		//int[] heights = {1,5,3,6,7,6,5}; // [0,0,2,0,0,5,6]
		int[] heights = {1,2,3,4}; // [0,0,0,0]
		
		int[] answer = solution(heights);
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
