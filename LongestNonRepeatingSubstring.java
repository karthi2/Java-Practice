import java.util.HashMap;

public class LongestNonRepeatingSubstring {
	int startIndex;
	int[] alphabet = new int[26];
	int[] seenAtIndex = new int[26];

	public static void main(String[] args) {
		String s = "abcabcacfbasfkllasmmdxalsqwdjksnjnjskndskjnkdsnfldsmwfoewjdqpwjiruwgnvkjsdcdefghijklmnopqrstuvwxyz";
		HashMap<Character, Integer> hm = new HashMap<>();
		int startIndex = 0;
		String longestSubString = "";
		boolean found = false;

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < s.length(); i++) {
			startIndex = i;
			for (int j = i; j < s.length(); j++) {
				if (hm.containsKey(s.charAt(j))) {
					if (longestSubString.length() < s.substring(startIndex, j).length()) {
						longestSubString = s.substring(startIndex, j);
					}
					hm.clear();
					found = true;
					break;
				} else {
					hm.put(s.charAt(j), j);
				}
			}
			if (found == true) {
				found = false;
			} else {
				if (longestSubString.length() < s.substring(startIndex).length()) {
					longestSubString = s.substring(startIndex);
				}
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time was " + (endTime - startTime) + " miliseconds.");
		System.out.println(longestSubString);
		
		/*
		 * Optimal way to do the same thing
		 */
		StringBuilder sb = new StringBuilder();
		int end = -1;
		int start = 0;
		startIndex = 0;
		int maxLen = 0;
		int resEndIndex = 0;
		int resStartIndex = 0;
		int i = 0;
		
		startTime = System.currentTimeMillis();
		for (i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (sb.lastIndexOf(c.toString()) == -1) {
				sb.append(c);
			} else {
				if (maxLen < (i - startIndex)) {
					maxLen = i - startIndex;
					resStartIndex = startIndex;
					resEndIndex = i;
				}
				
				startIndex = s.indexOf(c.toString(), startIndex) + 1;
				end = sb.lastIndexOf(c.toString());
				sb.delete(start, end + 1);
				sb.append(c);
			}
		}
		
		if (maxLen < (i - startIndex)) {
			maxLen = i - startIndex;
			resStartIndex = startIndex;
			resEndIndex = i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed time was " + (endTime - startTime) + " miliseconds.");
		System.out.println(s.substring(resStartIndex, resEndIndex) + " " + maxLen);
		
	}
}
