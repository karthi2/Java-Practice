public class Anagram {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		
		char[] c = s.toCharArray();
		
		printAnagrams(c, 0, s.length() - 1);
		
		StringBuilder sb = new StringBuilder();
	}

	private static void printAnagrams(char[] c, int left, int right) {
		// TODO Auto-generated method stub
		
		if (left == right) {
			System.out.println(c);
		} else {
			for (int i = left; i < right; i++) {
				char temp = c[left];
				c[left] = c[i];
				c[i] = temp;
				
				printAnagrams(c, left + 1, right);
				
				temp = c[left];
				c[left] = c[i];
				c[i] = temp;
			}
		}
	}
}
