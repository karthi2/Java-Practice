
public class LeetCodeEasy_ValidPalindrome2 {
	public static void main (String args[]) {
		String s = "cbbcc";

		if (isValidPalindrom(s)) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	private static boolean isPalindrome (String s) {
		int j = s.length() - 1;
		int i = 0;
		
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	private static boolean isValidPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;

		if (i == j) {
			return true;
		}

		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				boolean isPalindrom = isPalindrome(s.substring(i, j));
				System.out.println(s.substring(i) + " " + isPalindrom);
				if (isPalindrom) {
					return true;
				} else {
					
					isPalindrom = isPalindrome(s.substring(i+1, j+1));
					System.out.println(s.substring(i+1, j+1) + " " + isPalindrom);
					return isPalindrom;
				}
			}
		}
		
		return true;
	}
}
