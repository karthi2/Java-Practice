import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		int n = nums.length;
		List<List<Integer>> result = new LinkedList<>();

		permutation(nums, n, result, new ArrayList<Integer>(), new HashSet<Integer>());
		System.out.println(result.size());
		
		result.clear();
		/* Another way */
		permutation(nums, 0, n, result);
		System.out.println(result.size());
	}

	private static void permutation(int[] nums, int n, 
									List<List<Integer>> result,
									List<Integer> list, HashSet<Integer> hs) {
		// TODO Auto-generated method stub
		if (list.size() == n) {
			result.add(new ArrayList<Integer>(list));
		}

		for (int i = 0; i < n; i++) {
			if (hs.contains(nums[i])) {
				continue;
			}
			
			list.add(nums[i]);
			hs.add(nums[i]);
			permutation(nums, n, result, list, hs);
			hs.remove(list.get(list.size()-1));
			list.remove(list.size()-1);
		}
	}
	
	private static void permutation(int[] nums, int start, int n,
									List<List<Integer>> result) {
		if (start >= n) {
			List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = start; i < n; i++) {
			swap(nums, start, i);
			permutation(nums, start+1, n, result);
			swap(nums, start, i);
		}
	}
	
	private static void swap (int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
