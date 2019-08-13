import java.util.ArrayList;

public class Etc_03 {
	//배열, Array, List만을 사용해서 작성
	public static int solution(int[] index, String value) {
		int answer;
		String[][] puzzle = new String[10][9];
		puzzle[1][1] = "PROGRAM"; puzzle[1][5] = "CSS";
		puzzle[1][8] = "QUEUE"; puzzle[2][3] = "CPU";
		puzzle[3][3] = "PUSH"; puzzle[3][6] = "HIT";
		puzzle[4][1] = "GPU"; puzzle[5][6] = "TREE";
		puzzle[6][4] = "ROM"; puzzle[7][1] = "MEMORY";
	
		String right = puzzle[index[0]][index[1]];
		if(right==null)
			answer = -1;
		else if(right.equals(value))
			answer = 1;
		else
			answer = 0;
		
		return answer;
	}
	public static void run() {
		int[] index = {1, 1};
		//int[] index = {1, 2};
		String value = "PROGRAM";
		//String value = "MEMORY";
		
		// {1,1} : PROGRAM	{3,3} : PUSH
		// {7,1} : MEMORY	{1,5} : CSS
		// {6,4} : ROM	{3,6} : HIT
		// {4,1} : GPU	{5,6} : TREE
		// {2,3} : CPU	{1,8} : QUEUE
		
		System.out.println("answer = "+solution(index, value));
		
	}
}
