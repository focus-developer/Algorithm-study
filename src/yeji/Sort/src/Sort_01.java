import java.util.Arrays;

public class Sort_01 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0;i<commands.length;i++) {
			int size = commands[i][1]-commands[i][0]+1;
			int[] split = new int[size];
			int index = commands[i][0]-1;
			for(int k=0;k<size;k++) {
				split[k] = array[index++];
			}
			Arrays.sort(split);
			answer[i] = split[commands[i][2]-1];
		}
		
        return answer;
	}
	
	public static void run() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		
		int[] answer = solution(array, commands);
		System.out.print("answer = ");
		for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+" ");
	}

}
