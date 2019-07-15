import java.util.Arrays;

class Solution {
    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        // "leo", "kiki", "eden" // "eden", "kiki"
        // "marina", "josipa", "nikola", "vinko", "filipa" // "josipa", "filipa", "marina", "nikola"
        // "mislav", "stanko", "mislav", "ana" // "stanko", "ana", "mislav"

        System.out.println("answer = " + solution(participant, completion));

    }
    public static String solution(String[] participant, String[] completion) {


        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {

            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }


        return participant[participant.length-1];

    }

}