import java.util.Arrays;

public class Leetcode198 {
	/****** RECURSION ******/
	/* Recursive relation
	 * 
	 * robValue = Math.max(currentHouseValue + rob(i-2), rob(i-1))
	 */
	private int rob (int[] nums) {
		return rob(nums, nums.length - 1);
	}
	
	private int rob (int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		
		return Math.max(nums[i] + rob(nums, i-2), rob(nums, i-1));
	}
	
	/****** RECURSION + MEMOIZATION ******/
	private int memoRob (int[] nums) {
		int len = nums.length;
		int[] memo = new int[len];
		Arrays.fill(memo, -1);
		
		return memoRob(nums, memo, len-1);
	}
	
	private int memoRob (int[] nums, int[] memo, int i) {
		if (i < 0) {
			return 0;
		}
		
		if (memo[i] != -1) {
			return memo[i];
		}
		
		memo[i] = Math.max(nums[i] + memoRob(nums, memo, i-2), 
							memoRob(nums, memo, i-1));
		return memo[i];
	}
	
	
	public static void main (String[] args) {
		Leetcode198 obj = new Leetcode198();
		
		int[] nums = {2,7,9,3,1,12,9,14,24,13,19};
		
		long startTime = System.nanoTime();
		System.out.println(obj.rob(nums));
		long stopTime = System.nanoTime();
		System.out.println("Recursion time: " + (stopTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(obj.memoRob(nums));
		stopTime = System.nanoTime();
		System.out.println("Memo Time: " + (stopTime - startTime));
	}
}
