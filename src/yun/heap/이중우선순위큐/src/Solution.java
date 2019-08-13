import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String [] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; //return [0,0]
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; //return [333, -45]
        String[] operations = {"I 16","D 1"}; //return [0, 0]
//        String[] operations = {"I 7","I 5","I -5","D -1"}; //return [7, 5]

        int [] answer = solution(operations);
        for(int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = {};

        answer = new int[2];

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();


        for(int i=0; i<operations.length; i++) {
            String [] arr = operations[i].split(" ");
            switch (arr[0]) {
                case "I" :
                    maxHeap.add(Integer.parseInt(arr[1]));
                    minHeap.add(Integer.parseInt(arr[1]));
                    break;
                case "D" :
                    if(arr[1].equals("-1")) { //최솟값 삭제
                        if(!minHeap.isEmpty()) {
                            int min = minHeap.peek();
                            minHeap.remove(min);
                            maxHeap.remove(min);
                        }
                    }else if(arr[1].equals("1")){ //최댓값 삭제
                        if(!maxHeap.isEmpty()) {
                            int max = maxHeap.peek();
                            maxHeap.remove(max);
                            minHeap.remove(max);
                        }
                    }
                    break;
            }
        }

        if(!maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }



        return answer;
    }
}
