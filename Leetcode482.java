
public class Leetcode482 {
	public static void main (String[] args) {
		String S = "k";
		int K = 4;
		
		String[] arr = S.split("-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		for (int i = sb.length()-1; (i-K) >= 0; i = i-K) {
			sb.insert(i-K+1, '-');
		}
		
		System.out.println(sb.toString().toUpperCase());
	}
}
