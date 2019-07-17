import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Hash_04 {
	public static List sortByValue(Map map) {
		ArrayList<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;
	}
	

	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int songs = genres.length;
        
        HashMap<String, Integer> songsMapByGenres = new HashMap<>();
        for(int i=0;i<songs;i++) {
        	if(songsMapByGenres.get(genres[i])==null)
        		songsMapByGenres.put(genres[i], plays[i]);
        	else 
        		songsMapByGenres.put(genres[i], songsMapByGenres.get(genres[i])+plays[i]);
        }
        
        Iterator it = sortByValue(songsMapByGenres).iterator();
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        while(it.hasNext()) {
        	String key = (String)it.next();
        	HashMap<Integer, Integer> songsMapByPlays = new HashMap<>();
        	for(int i=0;i<songs;i++) {
        		if(genres[i].equals(key))
        			songsMapByPlays.put(i,plays[i]);
        	}
        	
        	
        	Iterator it2 = sortByValue(songsMapByPlays).iterator();
        	if(songsMapByPlays.size()==1)
        		bestAlbum.add((Integer)it2.next());
        	else {
        		for(int i=0;i<2;i++) {
            		Integer key2 = (Integer)it2.next();
            		bestAlbum.add(key2);
            	}
        	}
        	
        }
        
        answer = new int[bestAlbum.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = bestAlbum.get(i);
        }
        
        return answer;
	}
	
	public static void run() {
		String[] genres = {"classic", "pop", "classic", "classic", "pop","jazz"};
		int[] plays = {500, 600, 150, 800, 2500, 200};
		int[] answer = solution(genres, plays);
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
		
		
	}

}
