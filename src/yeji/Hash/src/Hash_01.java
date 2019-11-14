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
        				compare.compute(participant[i], (k, v) -> v+1);
        				
        				if(sameName.get(participant[i])==null)
        					sameName.put(participant[i], 1);
        				else 
        					sameName.compute(participant[i], (k, v) -> v+1);
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
    			
    			if(sameName.get(key)!=compare.get(key)) {
    				answer = key;
            		return answer;
    			}
    		}
    	}
        
        return answer;
    }
	
	public static void run() {
		String[] participant = {"leo","kiki","eden","rian"};
		String[] completion = {"eden","kiki","leo"};
		
		System.out.println("answer: "+solution(participant, completion));
	}
	
}
