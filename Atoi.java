
public class Atoi {
	public static void main (String args[]) throws ArrayIndexOutOfBoundsException {
		String s = args[1];
		
		String str = s.trim();
		char[] c = str.toCharArray();
		int result = 0;
		
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= '0' && c[i] <= '9') {
				result = result * 10 + Integer.parseInt(((Character)c[i]).toString());
			} else {
				break;
			}
		}
		
		
		System.out.println(result);
	}
}
