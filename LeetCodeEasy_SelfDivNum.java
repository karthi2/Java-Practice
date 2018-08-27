import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LeetCodeEasy_SelfDivNum {
	public static void main (String args[]) {
		int left = 1;
		int right = 40;
		boolean isSelfDiv = true;
		
		LinkedList<Integer> list = new LinkedList<>();
		
		ArrayList<Integer> digits = new ArrayList<>();
		
		for (int i = left; i <= right; i++) {
			int n = i;
			while (n != 0) {
				int rem = n % 10;
				if (rem == 0) {
					digits.clear();
					break;
				}
				
				digits.add(rem);
				n = n / 10;
			}
			
			if (!digits.isEmpty()) {
				Iterator<Integer> iter = digits.iterator();
				while (iter.hasNext()) {
					if (i % iter.next() != 0) {
						isSelfDiv = false;
						break;
					}
				}
				
				if (!isSelfDiv) {
					isSelfDiv = true;
				} else {
					list.add(i);
				}
				digits.clear();
			}
		}
		
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
