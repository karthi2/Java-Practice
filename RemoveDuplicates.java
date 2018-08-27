import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * Given an array of numbers such a "4 1 2 2 4", describe an algorithm to 
 * remove duplicates, producing for instance "4 1 2".
 * 
 * Output should retain the same order as the input array.
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] a = {4, 1, 1, 2, 2, 4, 4, 5, 2, 3, 7, 9, 10, 12, 12, 10, 11, 5, 7};
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < a.length; i++) {
			if (!hm.containsValue(a[i])) {
				hm.put(i, a[i]);
			}
		}
		
		Iterator<Entry<Integer, Integer>> iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().getValue() + " ");
		}
		System.out.println();
		
		/*
		 * If the order need not be maintained
		 */
		Arrays.sort(a);
		//ArrayList<Integer> result = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		for (i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i + 1]) {
				//result.add(a[i]);
				a[j++] = a[i];
			}
		}
		
		/*
		 * Add the last element left
		 */
		//result.add(a[i]);
		a[j++] = a[a.length - 1];
		
		for (i = 0; i < j; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
