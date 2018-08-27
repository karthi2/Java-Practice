/*
 * Not working
 */

import java.util.ArrayList;
import java.util.Iterator;

public class LeetCodeMonotone {
	static ArrayList<Integer> digits = new ArrayList<>();
	public static void main (String args[]) {
		Integer n = 548377855;
		int num = n;
		
		while (num != 0) {
			int rem = num % 10;
			digits.add(rem);
			num = num / 10;
		}
		
		while (true) {
			if (validate()) {
				break;
			}
		}
		
		for (int i = digits.size() - 1; i >= 0; i--) {
			 num = num * 10 + digits.get(i);
		}
		
		digits.clear();
		System.out.println(num);
	}

	private static boolean validate() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < digits.size() - 1; i++) {
			try {
				if (digits.get(i) < digits.get(i + 1)) {
					if (digits.get(i+1) == 9) {
						digits.set(i, 9);
						digits.set(i+1, 8);
					} else {
						digits.set(i, 9);
						if (digits.get(i+1) != 9) {
							digits.set(i + 1, digits.get(i + 1) - 1);
						}
					}
					return false;
				}
			} catch (Exception e) {
				System.out.println("Accessing invalid index " + i);
				e.printStackTrace();
				throw e;
			}
		}
		
		return true;
	}
}
