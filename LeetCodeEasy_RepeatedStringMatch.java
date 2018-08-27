
public class LeetCodeEasy_RepeatedStringMatch {
	public static void main (String args[]) {
		String a = "aa";
		String b = "a";
		int count = 0;
		
		if (a.equals(b) || a.contains(b)) {
			System.out.println(1);
		} else if (!b.contains(a)) {
			System.out.println(0);
		} else {
			StringBuffer sb = new StringBuffer(a+a);
			count = 2;
			while (true) {
				if (sb.toString().contains(b)) {
					System.out.println(count);
					break;
				}
				count++;
				sb.append(a);
			}
		}
	}
}
