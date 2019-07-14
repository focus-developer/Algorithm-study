import java.util.HashMap;
import java.util.Iterator;

public class Hash_01 {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> compare = new HashMap<>();
        HashMap<String, Integer> sameName = new HashMap<>();
        
        boolean isCompletion = false;
        
        for(int i=0;i<participant.length;i++) {
        	for(int j=0;j<completion.length;j++) {
        		if(participant[i].equals(completion[j])) {
        			if(compare.get(participant[i])==null)
        				compare.put(participant[i], 1);
        			else {
        				if(sameName.get(participant[i])==null)
        					sameName.put(participant[i], 2);
        				else {
        					int tmp = sameName.get(participant[i]);
        					sameName.put(participant[i], tmp+1);
        				}
        			}
        			isCompletion = true;
        		}
        	}
        	
        	if(!isCompletion) {
        		answer = participant[i];
        		return answer;
        	}
        	
        	isCompletion=false;
        }
        

    	if(!sameName.isEmpty()) {
    		Iterator<String> iterator = sameName.keySet().iterator();
    		while(iterator.hasNext()) {
    			String key = iterator.next();
    			int count=0;
    			for(int i=0;i<completion.length;i++) {
    				if(completion[i].equals(key))
    					count++;
    			}
    			System.out.println("count="+count);
    			
    			if(sameName.get(key)!=count) {
    				answer = key;
            		return answer;
    			}
    		}
    	}
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] participant = {"leo","kiki","eden","kiki","leo"};
		String[] completion = {"eden","kiki","leo","kiki"};
		
		System.out.println("미완주자: "+solution(participant, completion));
	}
	
}
