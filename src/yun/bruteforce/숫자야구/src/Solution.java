public class Solution {

    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;

        for(int i=123; i<=987; i++) {
            String[] toStr = Integer.toString(i).split("");

            if(toStr[0].equals(toStr[1]) || toStr[0].equals(toStr[2]) || toStr[1].equals(toStr[2])) continue;
            if(toStr[0].equals("0") || toStr[1].equals("0") || toStr[2].equals("0")) continue;

            for(int size=0; size<baseball.length; size++) {
                int strike = 0;
                int ball = 0;

                for(int x=0; x<3; x++) {
                    for(int y=0; y<3; y++) {
                        String[] arr = Integer.toString(baseball[size][0]).split("");

                        if(x == y && toStr[x].equals(arr[y])) {
                            strike++;
                            continue;
                        }
                        else if(toStr[x].equals(arr[y])) {
                            ball++;
                            continue;
                        }
                    }
                }

                if(strike != baseball[size][1] || ball != baseball[size][2]) {
                    break;
                }
                if(size == baseball.length-1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
