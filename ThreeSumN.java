import java.util.HashMap;

public class ThreeSumN {
	public static void main (String args[]) {
		int[] a = {9, 10, 0, -5, -2, -7};
		int n = 1;

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			hm.put(a[i], 1);
		}

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int num = n - (a[i] + a[j]);
				if (hm.containsKey(num)) {
					System.out.println(a[i] + " " + a[j] + " " + (n - (a[i] + a[j])));
					return;
				}
			}
		}
	}
}