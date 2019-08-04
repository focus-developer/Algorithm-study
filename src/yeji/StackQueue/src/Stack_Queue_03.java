import java.util.Stack;

public class Stack_Queue_03 {
	public static int solution(String arrangement) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arrangement.length();i++) {
        	if(arrangement.charAt(i) == '(') {
        		stack.push("(");
        	}
        	else if(arrangement.charAt(i)==')') {
        		if(arrangement.charAt(i-1)=='(') {
        			stack.pop();
        			answer += stack.size();
        		}
        		else {
        			stack.pop();
        			answer += 1;
        		}
        			
        	}
        }
        
        
        return answer;
    }
	
	public static void run() {
		String arrangement = "()(((()())(())()))(())"; //17
		
		System.out.println("answer = "+solution(arrangement));
	}
}
