import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode300 {
	private static int longestSubsequence (int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int len = nums.length;
		
		list.add(nums[0]);
		
		for (int i = 1; i < len; i++) {
			if (nums[i] > list.get(list.size()-1)) {
				list.add(nums[i]);
			} else {
				/*
				 * Binary search for the index where nums[i] can be inserted.
				 * Replace the next highest element with nums[i]
				 */
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j) == nums[i]) {
						break;
					}
					if (list.get(j) > nums[i]) {
						list.remove(j);
						list.add(j, nums[i]);
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		
		return list.size();
	}
	
	public static void main(String[] args) {
		int[] nums = {4,10,4,3,8,9};

		if (nums.length == 0) {
			System.out.println(nums.length);
			return;
		}
		
		System.out.println(longestSubsequence(nums));
		
		/* Method 2 */
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
			}
		}
		
		System.out.println(dp[nums.length-1]);
	}
}
