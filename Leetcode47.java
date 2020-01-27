import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,2,1,2};
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		boolean[] seen = new boolean[nums.length];
		
		permutation(nums, result, new ArrayList<>(), seen);
		System.out.println(result.size());
	}

	private static void permutation(int[] nums, List<List<Integer>> result, 
									ArrayList<Integer> list, boolean[] seen) {
		// TODO Auto-generated method stub
		if (list.size() == nums.length) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1] && !seen[i-1] || seen[i]) {
				continue;
			}
			list.add(nums[i]);
			
			seen[i] = true;
			permutation(nums, result, list, seen);
			seen[i] = false;
			list.remove(list.size()-1);
		}
	}
}
