import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {

    public static Set<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) {

        String numbers = "17"; // 3
//        String numbers = "011"; // 2

        int answer = solution(numbers);

        System.out.println("answer = " + answer);
    }

    public static int solution(String numbers) {
        int answer = 0;


        String [] num_arr = numbers.split("");
        int [] num_int = new int[num_arr.length];

        for(int i=0; i<num_arr.length; i++) {
            num_int[i] = Integer.parseInt(num_arr[i]);
        }


        for(int i=1; i<=num_int.length; i++) {
            permutation(num_int, 0, num_int.length, i);
        }

        for(int x : set) { //set 안에 숫자들을 반복
            int count = 0; // 약수의 개수
            int half = x/2; // 수를 2로 나눈 몫을 half에 저장


            if (x == 1){ // 수가 1일경우 소수가 아니므로 continue
                continue;
            }

            for(int i=1; i<=half; i++) { // half만큼만 반복. half이후 수는 무조건 몫이 1이기 때문
                if(x%i == 0) {
                    count++;
                }
            }

            if(count == 1) { // half만큼만 반복하므로 count개수가 2가 아닌 1로 처리한다. 
                answer++;
            }

        }


        return answer;
    }

    // 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            String num_s = "";
            for(int i=0; i<r; i++) {
                num_s = num_s + arr[i];
            }
            int num = Integer.parseInt(num_s);
            set.add(num); // 중복을 피하기 위해 set 자료구조 이용

            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
