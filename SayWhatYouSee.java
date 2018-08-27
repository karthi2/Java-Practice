public class SayWhatYouSee {
	public static void main (String args[]) {
		String[] s = {"1211"};
		StringBuffer[] res = new StringBuffer[s.length];
		String result[] = new String[s.length];
		
		for (int i = 0; i < s.length; i++) {
			res[i] = new StringBuffer();
		}
		
		int count = 1;
		int i = 0;

		for (int j = 0; j < s.length; j++) {
			for (i = 0; i < s[j].length() - 1; i++) {
				if (s[j].charAt(i) == s[j].charAt(i + 1)) {
					count++;
				} else {
					res[j].append(Integer.toString(count));
					res[j].append(s[j].charAt(i));
					count = 1;
				}
			}
			res[j].append(Integer.toString(count));
			res[j].append(s[j].charAt(i));
			count = 1;

			result[j] = res[j].toString();
			System.out.println(result[j]);
		}
	}
}