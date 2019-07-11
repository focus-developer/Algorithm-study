import java.util.*;

public class Etc_01 {
	public static void run() {
		// int[] v = {1,2,3,3,3,4,4};
		//int[] v = { 3, 2, 4, 4, 2, 5, 2, 5, 5 };
		// int[] v = {3,5,7,9,1};
		int[] v = {5,5,5,5,1,10,10,10,20,1};

		int[] answer = solution(v);

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
		System.out.println("");
	}

	public static int[] solution(int[] param) {
		int[] answer = {};

		LinkedHashMap<Integer, Integer> overlapList = new LinkedHashMap<>();

		ArrayList<Integer> overlapCount = new ArrayList<>();

		for (int i = 0; i < param.length; i++) {
			if (overlapList.get(param[i]) != null)
				overlapList.put(param[i], overlapList.get(param[i]) + 1);
			else
				overlapList.put(param[i], 1);
		}

		Iterator<Integer> iterator = overlapList.keySet().iterator();
		while (iterator.hasNext()) {
			int key = iterator.next();
			if (overlapList.get(key) > 1)
				overlapCount.add(overlapList.get(key));
		}
		
		if(overlapCount.size()==0) {
			answer = new int[1];
			answer[0] = -1;
		}
		else {
			answer = new int[overlapCount.size()];
			for(int i=0;i<overlapCount.size();i++) {
				answer[i] = overlapCount.get(i);
			}
		}

		return answer;

	}

}
