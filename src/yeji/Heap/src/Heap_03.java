import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_03 {
	public static class Job implements Comparable<Job>{
		int req;
		int work;
		
		public Job(int req, int work) {
			this.req = req;
			this.work = work;
		}

		@Override
		public int compareTo(Job target) {
			if (this.work > target.work) {
	            return 1;
	        } else if (this.work < target.work) {
	            return -1;
	        }
	        return 0;
		}		
	}
	
	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				final int req1 = entry1[0];
                final int req2 = entry2[0];
                return Integer.compare(req1, req2);
			}
		});
		
        int answer = 0;
        int count = jobs.length;
        int index = 0;
        
        int working = 0;
        PriorityQueue<Job> queue = new PriorityQueue<>();
        
        int i=0;
        while(index!=count || !queue.isEmpty()) {
        	while(index!=count && i == jobs[index][0]) {
        		queue.add(new Job(jobs[index][0],jobs[index][1]));
        		index++;
        	}
        	
        	if(working==0) {
        		Job curJob = queue.poll();
        		if(curJob!=null) {
        			working = curJob.work-1;
            		answer += i-curJob.req+curJob.work; //(현재시간-요청시간+작업시간)
        		}
        	}else {
        		working--;
        	}
        	
        	i++;
        }
        
        return answer/count;
    }
	
	public static void run() {
		int[][] jobs = {{0,3},{1,9},{2,6}}; //9
		//int[][] jobs = {{0,4},{2,5},{4,2},{5,3}}; //5.5 -> 5
		//int[][] jobs = {{0,5},{1,2},{5,5}}; //6
		//int[][] jobs = {{0,9},{0,4},{0,5},{0,7},{0,3}}; //13
		
		System.out.println("answer = "+solution(jobs));
	}
}
