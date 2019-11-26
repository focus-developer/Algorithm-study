import java.util.HashSet;

public class BruteForce02 {

	static HashSet<Integer> numberSet = new HashSet<>();
	
	//순열 찾기 함수
	static void permutation(int[] arr, int depth, int n, int r) {
	    if(depth == r) {
	        print(arr, r);
	        return;
	    }
	 
	    for(int i=depth; i<n; i++) {
	        swap(arr, depth, i);
	        permutation(arr, depth + 1, n, r);
	        swap(arr, depth, i);
	    }
	}
	 
	static void swap(int[] arr, int depth, int i) {
	    int temp = arr[depth];
	    arr[depth] = arr[i];
	    arr[i] = temp;
	}

	public static void print(int[] nums, int r) {
		String num = "";
		for(int i=0;i<r;i++) {
			num = num+ Integer.toString(nums[i]);
		}
		numberSet.add(Integer.parseInt(num));
	}
	
	public static boolean isPrime(int num) {
		boolean result = true;
		if(num <= 1)
			result = false;
		
		//num이 2일 경우 반복문을 돌지 않음 -> result = true
		for (int i = 2; i < num; i++) {
            if (num % i == 0) {
            	result = false; 
                break; //하나라도 1과 자기자신 외에 나눠지는 수가 있을경우 합성수이므로 반복문을 나감
            }
        }
		return result;
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		
		int[] nums = new int[numbers.length()];
		for(int i=0;i<numbers.length();i++) {
			nums[i] = Integer.parseInt(numbers.substring(i,i+1));
		}
		
		for(int i=1;i<=numbers.length();i++) {
			permutation(nums,0, nums.length, i);
		}
		
		System.out.println(numberSet);
		
		for(int num: numberSet) {
			if(isPrime(num)) {
				System.out.println(num);
				answer++;
			}
		}
		
        return answer;
	}
	
	public static void run() {
		String numbers = "17";
		//String numbers = "011";
		//String numbers = "012";
		
		System.out.println("answer = "+solution(numbers));
	}
}
