import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3}; //return [4, 3, 1, 1, 0]

        int [] answer = solution(prices);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }

    public static int[] solution(int[] prices) {
        int[] answer = {};

        int count = 0;

        answer = new int[prices.length];

        int i;
        for(i=0; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                count++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }

        return answer;
    }
}
