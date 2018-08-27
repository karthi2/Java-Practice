import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of values, (not necessary integers are positives) and a 
 * value. Print all the pairs whose sum is given value. Write a 
 * general method which can accept integers, float, doubles, long, or any other 
 * thing where this make sense.
 * 
 * Assume the elements are all unique
 */
public class PairOfNumSum {
	
	public void pairs (int[] array, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			hm.put(i, array[i]);
		}
		
		for (int i = 0; i < array.length; i++) {
			if (hm.containsValue(sum - array[i])) {
				System.out.println(array[i] + " " + (sum - array[i]));
				hm.remove(i);
			}
		}
		System.out.println("****************");
		
		Arrays.sort(array);
		int i = 0;
		int j = array.length - 1;
		
		while (i < j) {
			if (array[i] + array[j] == sum) {
				System.out.println(array[i] + " " + array[j]);
				i++;
				j--;
			} else if (array[i] + array[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {15, 7, 16, 1, 9, 22, 49, 65};
		int sum = 31;
		
		PairOfNumSum p = new PairOfNumSum();
		p.pairs(a, sum);
	}

}
