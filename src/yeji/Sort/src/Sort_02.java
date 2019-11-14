import java.util.Arrays;
import java.util.Collections;

public class Sort_02 {
	public static String solution(int[] numbers) {
		String answer = "";
		Integer[] tmp = new Integer[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			int length = (int)(Math.log10(numbers[i])+1); //자릿수 구하기
			if(numbers[i]==0 || numbers[i]==1000)
				tmp[i] = numbers[i];
			else {
				switch(length) {
				case 1:
					tmp[i] = numbers[i] * 11110 + 4;
					break;
				case 2:
					tmp[i] = numbers[i] * 1000 + numbers[i]*10 + 3;
					break;
				case 3:
					tmp[i] = numbers[i] * 100 + (numbers[i]/100)*10 + 2;
					break;
				}
			}
		}
		
		Arrays.sort(tmp, Collections.reverseOrder());
		for(int i=0;i<numbers.length;i++) {
			int num = (int)(tmp[i] / Math.pow(10, tmp[i]%10));
			answer += Integer.toString(num);
		}
		
		if(answer.charAt(0)=='0')
			answer = "0";
		
        return answer;
	}
	
	public static void run() {
		int[] numbers = {6, 10, 2}; //6210
		//int[] numbers = {3, 30, 34, 5, 9}; //9534330
		//int[] numbers = {5, 546}; //5546 
		//int[] numbers = {40, 403}; //40403
		//int[] numbers = {40, 405}; //40540
		//int[] numbers = {40, 404}; //40440
		//int[] numbers = {12, 121}; //12121
		//int[] numbers = {2, 22, 223}; //223222
		//int[] numbers = {21, 212}; //21221
		
		System.out.println("answer = "+solution(numbers));
		
	}
}
