public class Solution {

    public static void main(String[] args) {

        String arrangement = "()(((()())(())()))(())";

        int answer = solution(arrangement);
        System.out.println(answer);
    }

    public static int solution(String arrangement) {
        int answer = 0;
        int stack = 0;

        String [] arranges = arrangement.split("");

        for(int i=0; i<arranges.length; i++) {
            switch (arranges[i]) {
                case "(" :
                    stack++;
                    break;
                case ")" :
                    if(arranges[i-1].equals("(")) {
                        stack--;
                        answer += stack;
                    }else if(arranges[i-1].equals(")")){
                        stack--;
                        answer++;
                    }
                    break;
            }
        }


        return answer;
    }
}
