import java.util.*;

public class ThreeSumSmallest {
	private static List<int[]> threeSumSmallest(int[] a, int target) {
		List<int[]> result = new ArrayList<>();
		if (a.length == 0) {
			return result;
		}
		
		int k = a.length - 1;
		
		for (int i = 0; i < a.length-2; i++) {
			for (int j = i + 1; j < a.length-1 && j < k; j++) {
				if ((a[i] + a[j] + a[k]) < target) {
					while (j < k) {
						//System.out.println(a[i] + " " + a[j] + " " + a[k]);
						result.add(new int[] {a[i], a[j], a[k]});
						k--;
					}
					j++;
				} else {
					k--;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] a = {-2, 0, 1, 3};
		int target = 2;
		
		Arrays.sort(a);
		
		List<int[]> list = threeSumSmallest(a, target);
		Iterator<int[]> iter = list.iterator();
		
		while (iter.hasNext()) {
			int[] res = iter.next();
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}

}
