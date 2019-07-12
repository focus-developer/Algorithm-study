import java.util.HashMap;

public class Etc_02 {
	public static void run() {
		//int[] arr1 = {1, 5, 7, 2, 9, 13, 10}; int[] arr2 = {2, 3, 9, 10, 4, 8, 11}; //기대값 0
		//int[] arr1 = {1, 4, 1, 3, 5, 6, 10}; int[] arr2 = {9, 2, 3, 1, 3, 4, 10}; //기대값 2
		//int[] arr1 = {1, 1, 9, 4, 1, 3, 11}; int[] arr2 = {2, 3, 3, 13, 12, 9, 9}; //기대값 1
		//int[] arr1 = {1, 4, 9, 4, 1, 10, 13}; int[] arr2 = {11, 13, 9, 3, 1, 9, 1}; //기대값 2
		//int[] arr1 = {1, 4, 4, 4, 1, 10, 4}; int[] arr2 = {11, 13, 11, 3, 11, 9, 1}; //기대값 1
		int[] arr1 = {1, 2, 2, 4, 1, 10, 4}; int[] arr2 = {1, 2, 3, 3, 10, 9, 1}; //기대값 1
		
		
		System.out.println("answer = "+solution(arr1,arr2));
		//solution(arr1,arr2);
	}
	
	public static int[] countPair(int[] arr) {
		int[] result = new int[2];
		int key = 0;
		int maxPairCount = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
			}
			else {
				map.compute(arr[i], (k, v) -> v+1 );
				if(map.get(arr[i])>4)
					map.put(arr[i], 4);				
				if(map.get(arr[i])>=maxPairCount) {
					maxPairCount = map.get(arr[i]);
					if(key==0) {
						key = arr[i];
					}
					else {
						if(arr[i]>=key) 
							key = arr[i];
					}
				}
			}
		}
		
		result[0] = key;
		result[1] = maxPairCount;
		
		return result;
	}
	
	public static int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		int[] first, second; //[number,pairCount]
		
		first = countPair(arr1);
		second = countPair(arr2);
		
		if(first[1]==0&&second[1]==0)
			answer = 0;
		else if(first[1]>second[1])
			answer = 1;
		else if(first[1]<second[1])
			answer = 2;
		else if(first[1]==second[1]) {
			if(first[0]>second[0])
				answer = 1;
			else if(first[0]<second[0])
				answer = 2;
			else {
				answer = 0;
			}
		}
		
		
		return answer;
	}

}
