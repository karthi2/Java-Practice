
public class Leetcode1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pbbcggttciiippooaais";
		int k = 2;
		
		s = removeDuplicates(s, k);
		System.out.println(s);
	}

	private static String removeDuplicates(String s, int k) {
		// TODO Auto-generated method stub
		char p = s.charAt(0);
        int count = 1;
        int m = 1;
        
        for (int i = m; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == p) {
                count++;
                if (count == k) {
                    s = s.substring(0, i-k+1) + s.substring(i+1);
                    p = s.charAt(0);
                    i = m-1;
                    count = 1;
                    continue;
                }
            } else {
                count = 1;
            }
            p = c;
        }
		return s;
	}

}
