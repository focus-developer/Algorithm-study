public class Solution {

    public static void main(String[] args) {

        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public static int DFS(int[] numbers, int target, int index, int value) {
        if(index == numbers.length) {
            return value == target ? 1 : 0;
        }
        return DFS(numbers, target, index+1, value+numbers[index]) + DFS(numbers, target, index+1, value-numbers[index]);
    }
}
