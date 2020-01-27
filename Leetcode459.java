

public class Leetcode459 {
	public static void main (String[] args) {
		String s = "abcabcdsbudnsjcnafiuwhef";
		int numChar = 1;
		int len = s.length();
		
		while (numChar <= len/2) {
			String subString = s.substring(0, numChar);
			int subLen = subString.length();
			StringBuilder sb = new StringBuilder();
			int nLoops = len/numChar;
			
			if ((len % numChar == 0) && (len % subLen == 0)) {
				for (int i = 0; i < nLoops; i++) {
					sb.append(subString);
				}
				
				if (s.contains(sb.toString())) {
					System.out.println("True");
					return;
				}
			}
			numChar++;
		}
		System.out.println("False");
	}
}
