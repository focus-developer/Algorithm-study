import java.util.ArrayList;
import java.util.List;

public class Etc03 {

    public static void main(String[] args) {

//        int [] index = {1,1};
//        String value = "PROGRAM";
        int [] index = {7,1};
        String value = "MEMORY";

        int answer = solution(index, value);
        System.out.println(answer);
    }

    public static int solution(int[] index, String value) {
        int answer = 0;
        boolean check = true;

        List<Word> list = new ArrayList<>();
        list.add(new Word(1,1,"PROGRAM"));
        list.add(new Word(7,1,"MEMORY"));
        list.add(new Word(6,4,"ROM"));
        list.add(new Word(4,1,"GPU"));
        list.add(new Word(2,3,"CPU"));
        list.add(new Word(3,3,"PUSH"));
        list.add(new Word(1,5,"CSS"));
        list.add(new Word(3,6,"HIT"));
        list.add(new Word(5,6,"TREE"));
        list.add(new Word(1,8,"QUEUE"));

        for(int i=0; i<list.size(); i++) {
            if(index[0] == list.get(i).x && index[1] == list.get(i).y) {
                answer = list.get(i).getAnswer(value);
                check = false;
                break;
            }
        }
        if(check) answer = -1;

        return answer;
    }

    static class Word {

        public int x;
        public int y;
        public String value;

        public Word(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getAnswer(String value) {
            if(value.equals(this.value)) {
                return 1;
            }
            return 0;
        }
    }
}