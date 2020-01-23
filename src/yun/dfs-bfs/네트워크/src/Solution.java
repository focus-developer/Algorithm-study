public class Solution {

    private static boolean visit[];

    public static void main(String[] args) {
//        int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // return 2
        int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; // return 1

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                answer++;
                DFS(computers, i, n);
            }
        }

        return answer;
    }

    public static void DFS(int[][] computers, int index, int n) {
        visit[index] = true;
        for(int i=0; i<n; i++) {
            if(!visit[i] && computers[index][i] == 1) {
                DFS(computers, i, n);
            }
        }
    }
}
