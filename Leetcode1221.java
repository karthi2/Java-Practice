
public class Leetcode1221 {
	public static void main (String[] args) {
		String s = "RLLLLRRRLR";
		int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                result++;
            }
        }
        System.out.println(result);
	}
}
