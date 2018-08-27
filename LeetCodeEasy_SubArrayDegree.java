import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LeetCodeEasy_SubArrayDegree {
	public static void main (String args[]) {
		int[] nums = {1, 2, 2, 3, 1};
		int maxDegree = 0;
		
		int smallestSubArraySize = Integer.MAX_VALUE;
		
		HashMap<Integer, int[]> hm = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int value[] = new int[3];
			if (hm.containsKey(nums[i])) {
				value = hm.get(nums[i]);
				value[0] += 1;
				value[2] = i;
			} else {
				value[0] = 1;
				value[1] = i;
				value[2] = i;
			}
			
			hm.put(nums[i], value);
			
			if (maxDegree < value[0]) {
				maxDegree = value[0];
			}
		}
		
		Set<Integer> hashKeySet = hm.keySet();
		Iterator<Integer> iter = hashKeySet.iterator();
		int value[] = new int[3];
		
		while (iter.hasNext()) {
			value = hm.get(iter.next());
			if (value[0] == maxDegree) {
				int subArraySize = value[2] - value[1];
				
				if (subArraySize < smallestSubArraySize) {
					smallestSubArraySize = subArraySize;
				}
			}
		}
		
		System.out.println(smallestSubArraySize + 1);
	}
}
