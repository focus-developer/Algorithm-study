import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

//        int[] numbers = {6, 10, 2}; //Return "6210"
//        int[] numbers = {3, 30, 34, 5, 9}; //Return "9534330"

        int[] numbers = {0,0,0};


        String answer = solution(numbers);
        System.out.println(answer);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        int check = 0;

        String[] numToString = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numToString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numToString, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int first = Integer.parseInt(o1 + o2);
                int second = Integer.parseInt(o2 + o1);

                return second - first;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for(int i=0; i<numToString.length; i++) {
            answer += numToString[i];
            check += Integer.parseInt(numToString[i]);
        }
        if(check == 0) {
            answer = "0";
        }


        return answer;
    }
}
