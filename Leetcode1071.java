
public class Leetcode1071 {
	private static int getGCD (int len1, int len2) {
		if (len1 < len2) {
			getGCD(len2, len1);
		}
		if (len2 == 0) {
			return len1;
		}
		return getGCD(len2, len1 % len2);
	}

	public static void main(String[] args) {
		String s1 = "LEETC";
		String s2 = "A";

		int len1 = s1.length();
		int len2 = s2.length();

		int gcdlen = getGCD(len1, len2);
		String substr = s2.substring(0, gcdlen);
		/*
		if (substr.repeat(len2/gcdlen).equals(s2) && substr.repeat(len1/gcdlen).equals(s1)) {
			System.out.println(substr);
		} else {
			System.out.println("");
		}
		*/
	}
}
