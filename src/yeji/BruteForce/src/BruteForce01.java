import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce01 {
	public static class Person implements Comparable<Person>{
		int[] pattern = {1, 2, 3, 4, 5};
		int size;
		int count = 0;
		int number;
		
		public Person(int number, int[] pattern) {
			this.number = number;
			this.pattern = pattern;
			this.size = pattern.length;
		}
		
		public int compareTo(Person comparePerson) {
			return comparePerson.count - this.count;
		}
	}
	
	public static int[] solution(int[] answers) {
		int[] answer;
		int[] pattern1 = {1, 2, 3, 4, 5};
		int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int n = 0;
		
		Person[] persons = new Person[3];
		persons[0] = new Person(1, pattern1);
		persons[1] = new Person(2, pattern2);
		persons[2] = new Person(3, pattern3);
		
		for (int p = 0; p < 3; p++) {
			Person person = persons[p];
			for (int i = 0; i < answers.length; i++) {
				if (person.pattern[i % person.size] == answers[i]) {
					person.count += 1;
					System.out.println(p+":"+i+"번 정답");
				}
			}
			if(persons[p].count != 0)
				n++;
		}
		
		if(n==0) {
			// 3명 다 0점
			answer = new int[3];
			answer[0] = 1;
			answer[1] = 2;
			answer[2] = 3;
		}
		else {
			answer = new int[n];
			Arrays.sort(persons);
			for (int i = 0; i < n; i++) {
				answer[i] = persons[i].number;
			}
		}
		
		return answer;
	}
	
	public static void run() {
		//int[] answers = {1,2,3,4,5};
		//int[] answers = {1,3,2,4,2};
		int[] answers = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
		
		int[] answer = solution(answers);
		for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+" ");
		
		
	}

}
