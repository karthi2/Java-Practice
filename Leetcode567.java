import java.util.HashMap;

public class Leetcode567 {
	private static boolean permutate (String perm, String s1, String s2) {
		if (s1.isEmpty()) {
			if (s2.contains(perm)) {
				return true;
			}
		}

		for (int i = 0; i < s1.length(); i++) {
			if (permutate(perm + s1.charAt(i), 
					s1.substring(0, i) + 
					s1.substring(i+1, s1.length()), s2)) {
				return true;
			}
		}

		return false;
	}


	private static boolean checkInclusion (char c, String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}

		if (s2.contains(s1)) {
			return true;
		}

		int index = s2.indexOf(s1.charAt(0));
		if (index == -1) {
			return false;
		}

		if ((index+1) < s1.length()) {
			//return checkInclusion(c, s1, s2.substring(index+1, s2.length()));
			String s = findSubString2(index, s1.length(), s2);
			if (search(s1, s)) {
				return true;
			}
		} else {
			String s = findSubString(index, s1.length(), s2);
			if (search(s1, s)) {
				return true;
			}
		}

		return checkInclusion(c, s1, s2.substring(index+1, s2.length()));
	}

	private static String findSubString2(int index, int len, String s2) {
		// TODO Auto-generated method stub
		int wLen = len - 1;
		int remLen = s2.length() - index;
		if (remLen <= wLen) {
			return s2.substring(0, index) + s2.substring(index, index+remLen);
		} else {
			if (index == 0) {
				return s2.substring(0, index) + s2.substring(index, len);
			}
			return s2.substring(0, index) + s2.substring(index, len+1);
		}
	}


	private static String findSubString(int index, int len, String s2) {
		// TODO Auto-generated method stub
		if ((s2.length() - index) >= len) {
			return s2.substring(index - len + 1, index) + s2.substring(index, index+len);
		} else {
			return s2.substring(index - len + 1, index) + s2.substring(index);
		}
	}


	private static boolean search(String substring1, String substring2) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < substring1.length(); i++) {
			hm.put(substring1.charAt(i), hm.getOrDefault(substring1.charAt(i), 0)+1);
		}

		for (int i = 0; i < substring2.length(); i++) {
			char c = substring2.charAt(i);
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c)-1);
				if (hm.get(c) == 0) {
					hm.remove(c);
				}
			}
		}

		if (hm.isEmpty()) {
			return true;
		}

		return false;
	}

	private static boolean slidingWindow (String s1, String s2) {
		int[] count = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--; 
		}

		if (checkZero(count)) {
			return true;
		}
		
		for (int i = s1.length(); i < s2.length(); i++) {
			char c = s2.charAt(i);
			
			count[c - 'a']--;
			count[s2.charAt(i - s1.length()) - 'a']++;
			if (checkZero(count)) {
				return true;
			}
		}

		return false;
	}

	private static boolean checkZero(int[] count) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}


	public static void main (String[] args) {
		//"abcdxabcde"
		//"abcdeabcdx"
		String s1 = "ab";
		String s2 = "eidbaoo";

		System.out.println(permutate("", s1, s2));

		System.out.println(checkInclusion(s1.charAt(0), s1, s2));
		System.out.println(slidingWindow(s1, s2));
	}
}
