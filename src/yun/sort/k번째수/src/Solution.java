import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; //return [5, 6, 3]

        int [] answer = solution(array, commands);

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];

        int [] temp;


        for(int i=0; i<commands.length; i++) {
            int index = 0;
            temp = new int[commands[i][1]-commands[i][0]+1];
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                temp[index++] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
            temp = null;
        }

        return answer;
    }
}
