import java.util.*;

public class Solution {

    public static void main(String [] args) {

//        int [][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //return 9
//        int[][] jobs = {{0,4},{2,5},{4,2},{5,3}}; //5.5 -> 5
//        int[][] jobs = {{0,5},{1,2},{5,5}}; //6
        int[][] jobs = {{0,9},{0,4},{0,5},{0,7},{0,3}}; //13
        int answer = solution(jobs);

        System.out.println(answer);
    }
    public static int solution(int[][] jobs) {
        int answer = 0;

        Queue<Disk> queue = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int size = 0;
        int index = 0;


        while(index < jobs.length) {
            for(int i=index; i<jobs.length ; i++) {
                if(jobs[i][0] <= size && jobs[i][0] != -1) {
                    queue.add(new Disk(jobs[i][0], jobs[i][1]));
                    jobs[i][0] = -1;
                }

            }

            if(!queue.isEmpty()) {
                Disk disk = queue.peek();
                size += disk.length;
                answer = answer + size - disk.re_time;
                queue.poll();
                index++;
            }
            else {
                size++;
            }

        }

        answer /= jobs.length;

        return answer;
    }
    static class Disk implements Comparable<Disk>{
        public int re_time;
        public int length;

        public Disk(int re_time, int length) {
            this.re_time = re_time;
            this.length = length;
        }

        @Override
        public int compareTo(Disk target) {
            return this.length >= target.length ? 1 : - 1;
        }
    }
}
