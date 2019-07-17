import java.util.ArrayList;
import java.util.List;

class Solution {

    public static class Print {
        int location;
        int priority;

        public Print(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        public int getLocation() {
            return location;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {

//        int[] priorities = {2, 1, 3, 2};
//        int location = 2; // return => 1

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0; // return => 5

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 1; // return => 6

//        int[] priorities = {1, 2, 3, 4};
//        int location = 0; // return =>4

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        List<Print> prints = new ArrayList<>();

        for(int i=0; i<priorities.length; i++) {
            Print print = new Print(i, priorities[i]);
            prints.add(print);
        }

        boolean check = false;
        int index = 0;

        while(index < prints.size()) {
            Print temp = prints.get(index);
            for(int j=index+1; j<prints.size(); j++) {
                if(temp.getPriority() < prints.get(j).getPriority()) {
                    prints.add(temp);
                    prints.remove(index);
                    check = true;
                    break;

                }
            }
            if(check == false) {
                index++;

            }
            check = false;
        }

        for(int i=0; i<prints.size(); i++) {
            if(location == prints.get(i).getLocation()) {
                return i+1;
            }
        }


        return answer;
    }
}