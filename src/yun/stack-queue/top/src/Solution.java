class Solution {

    public static void main(String[] args) {
//        int[] heights = {6, 9, 5, 7, 4}; // [0, 0, 2, 2, 4]
//        int[] heights = {3, 9, 9, 3, 5, 7, 2}; // [0, 0, 0, 3, 3, 3, 6]
        int[] heights = {1, 5, 3, 6, 7, 6, 5}; // [0, 0, 2, 0, 0, 5, 6]

        int[] answer = solution(heights);
        for(int a : answer) {
            System.out.println(a);
        }
    }

    public static int[] solution(int[] heights) {
        int[] answer = {};

        answer = new int[heights.length];

        boolean check = false;

        for(int i=0; i<heights.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j+1;
                    check = true;
                    break;
                }
                if(j == 0 && check == false) {
                    answer[i] = 0;
                }
                check = false;
            }
        }

        return answer;
    }
}