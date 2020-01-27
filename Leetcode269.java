import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode269 {

	public static void main(String[] args) {
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		HashSet<Character> hs = new HashSet<>();
		List<Character> result = new ArrayList<>();
		
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				hs.add(c);
				if (j == 0) {
					if (!result.contains(c)) {
						result.add(c);
					}
				}
			}
		}
		
		List<Character> intermediate = new ArrayList<>();
		for (int i = 1; i < words.length; i++) {
			String s1 = words[i-1];
			String s2 = words[i];
			int j = 1;
			int k = 1;
			
			while (j < s1.length() && k < s2.length()) {
				char c1 = s1.charAt(j);
				char c2 = s2.charAt(k);
				
				if (c1 != c2) {
					if (!intermediate.contains(c1)) {
						intermediate.add(c1);
					}
					
					if (!intermediate.contains(c2)) {
						intermediate.add(c2);
					}
				}
				j++;
				k++;
			}
		}
	}
	
	private static void dfs (int[][] adj, int[][] visited) {
		
	}
}
