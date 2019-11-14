import java.util.Arrays;

public class Hash_02 {
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int size = phone_book.length;
        
        for(int i=0;i<size-1;i++) {
        	for(int j=i+1;j<size;j++) {
        		if(phone_book[j].startsWith(phone_book[i])) {
        			answer = false;
        			return answer;
        		}
        	}
        }
        return answer;
    }
	
	public static void run() {
		String[] phone_book = {"119", "97674223", "1195524421"}; //false
		//String[] phone_book = {"123","456","789"}; //true
		//String[] phone_book = {"12","123","1235","567","88"}; //false
		
		System.out.println("answer = "+solution(phone_book));
	}

}
