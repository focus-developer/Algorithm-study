import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_01 {
	
	public static class Print {
		int priority;
		int location;
		
		public Print(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}
		
		public void setLocation(int location) {
			this.location = location;
		}
		
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        
        ArrayList<Print> printer = new ArrayList<>();
        for(int i=0;i<size;i++) {
        	printer.add(new Print(priorities[i],i));
        }
        
        for(int i=0; i<size-1; i++) {
        	for(int j=i+1; j<size; j++) {
        		if(printer.get(i).priority < printer.get(j).priority) {
        			Print tmp = printer.get(i);
        			printer.remove(i);
        			printer.add(tmp);
        			i--;
        			break;
        		}
        	}
        }
        
        for(int i=0;i<size;i++) {
        	if(printer.get(i).location==location)
        		answer = i+1;
        }
        
        return answer;
    }
	
	
	public static void run() {
		int[] priorities = {2, 1, 3, 2}; int location = 2; // 1
		//int[] priorities = {1, 1, 9, 1, 1, 1}; int location = 0; // 5
		System.out.println("answer = "+solution(priorities, location));
	}

}
