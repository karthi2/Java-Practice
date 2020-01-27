public class Leetcode5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babd";
		String res = "";
		int maxLen = 1;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				String string = s.substring(i, j);
				if (checkPalindrome(string)) {
					if (string.length() > maxLen) {
						maxLen = string.length();
						res = string;
					}
				}
			}
		}

		System.out.println(res);
		
		/* Method 2 */
		res = "";
		maxLen = 1;
		for (int i = 0; i < s.length()-1; i++) {
			String string = null;
			
			/* Odd length palindrome */
			string = checkPalindrome(s, i, i);
			if (string.length() > maxLen) {
				maxLen = string.length();
				res = string;
			}
			
			/* Even length palindrome */
			string = checkPalindrome(s, i, i+1);
			if (string.length() > maxLen) {
				maxLen = string.length();
				res = string;
			}
		}
		System.out.println(res);
	}

	private static String checkPalindrome(String s, int i, int j) {
		// TODO Auto-generated method stub
		String palString = "";
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				palString = s.substring(i, j+1);
				i--;
				j++;
			} else {
				break;
			}
		}
		return palString;
	}

	private static boolean checkPalindrome(String s) {
		// TODO Auto-generated method stub
		
		int len = s.length();
		int mid1 = -1;
		int mid2 = -1;
		if (len % 2 == 0) {
			mid1 = len/2 - 1;
			mid2 = len/2;
		} else {
			mid1 = len/2;
			mid2 = mid1;
		}
		
		while (mid1 >= 0 && mid2 < len) {
			if (s.charAt(mid1) != s.charAt(mid2)) {
				return false;
			}
			mid1--;
			mid2++;
		}
		
		return true;
	}
}
