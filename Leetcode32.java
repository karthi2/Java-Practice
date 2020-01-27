import java.util.ArrayList;

public class Leetcode32 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()(()";
		int maxlen = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				list.add(i);
			} else {
				char c;
				if (!list.isEmpty()) {
					int index = list.get(list.size()-1);
					c = s.charAt(index);
					if (c == '(') {
						list.remove(list.size()-1);
						continue;
					}
				}

				list.add(i);
			}
		}
		
		if (list.isEmpty()) {
			System.out.println(s.length());
			return;
		}
		
		int x = s.length();
		for (int i = list.size()-1; i >= 0; i--) {
			maxlen = Math.max(maxlen, x - list.get(i) - 1);
			x = list.get(i);
		}
		
		maxlen = Math.max(maxlen, x);
		System.out.println(maxlen);
	}
}
