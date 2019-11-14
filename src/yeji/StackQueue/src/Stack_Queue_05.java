import java.util.ArrayList;

public class Stack_Queue_05 {
	
	static class Feature {
		boolean isComplete = false;
		int progress;
		int speeds;
		int develope;
		
		public Feature(int progress,int speeds) {
			this.progress = progress;
			this.speeds = speeds;
			
			this.develope = (100-progress)/speeds;
			if((100-progress)%speeds!=0)
				develope += 1;
			//System.out.println(progress+"/"+speeds+"/"+develope);
		}		
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<Integer> done = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++) {
        	features.add(new Feature(progresses[i],speeds[i]));
        }

        while(features.size()!=0) {
        	int count = 1;
        	for(int i=1;i<features.size();i++) {
        		if(features.get(0).develope >= features.get(i).develope) {
        			count++;
        			features.remove(i);
        			i--;
        		}else {
        			break;
        		}
        	}
        	features.remove(0);
        	done.add(count);
        }
        
        answer = new int[done.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = done.get(i);
        }
        
        return answer;
    }
	
	
	public static void run() {
		//int[] progresses = {93,30,55}; int[] speeds = {1,30,5}; // {2,1}
		//int[] progresses = {40, 93, 30, 55, 60, 65}; int[] speeds = {60, 1, 30, 5 , 10, 7}; // {1,2,3}
		int[] progresses = {93, 30, 55, 60, 40, 65}; int[] speeds = {1, 30, 5 , 10, 60, 7}; // {2,4}
		
		int[] answer = solution(progresses,speeds);
		
		System.out.print("answer = ");
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
