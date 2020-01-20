import java.util.*;

public class Solution {

    public static void main(String[] args) {

//        int brown = 10; int red = 2;
//        int brown = 8; int red = 1;
        int brown = 24; int red = 24;

        Arrays.stream(solution(brown, red)).forEach(System.out::println);

    }

    public static int[] solution(int brown, int red) {
        int[] answer = {};

        answer = new int[2];
        int sum = brown + red;

        for(int i=1; i<=sum; i++) {
            if(sum % i == 0) { // 약수 구하기
                int quotient = sum / i;
                if((quotient - 2) * (i - 2) == red) { // 빨간 카펫의 수가 맞는지 확인하기
                    answer[0] = quotient; // 가로에 더 큰수인 몫을 저장
                    answer[1] = i; // 세로에 더 작은수인 나눈 수를 저장 
                    break;
                }
            }
        }


        return answer;
    }
}
