import java.util.Arrays;
import java.util.HashSet;

public class Leetcode1079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAABBC";
		char[] c = s.toCharArray();
		HashSet<String> hs = new HashSet<>();
		
		permutation(c, hs, 0, s.length());
		System.out.println(hs.size());
	}

	private static void permutation(char[] c, HashSet<String> hs, int start, int end) {
		// TODO Auto-generated method stub
		if (start >= 1) {
			hs.add(String.valueOf(Arrays.copyOf(c, start)));
		}
		if (start == end) {
			//res.add(new String(c));
			return;
		}
		
		for (int i = start; i < end; i++) {
			swap(c, start, i);
			permutation(c, hs, start+1, end);
			swap(c, start, i);
		}
	}

	private static void swap(char[] c, int i, int j) {
		// TODO Auto-generated method stub
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}
}
