import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4,5,6,7};
		int target = 10;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		
		combinationSum(nums, target, res, new ArrayList<Integer>(), 0);
		
		for (List<Integer> list : res) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static int combinationSum(int[] nums, int target, List<List<Integer>> res, 
										ArrayList<Integer> list, int start) {
		// TODO Auto-generated method stub
		
		if (target < 0) {
			return 1;
		}
		
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return 0;
		}
		
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			int ret = combinationSum(nums, target-nums[i], res, list, i);
			list.remove(list.size()-1);
			if (ret > 0) {
				return 0;
			}
		}
		
		return 0;
	}

}
