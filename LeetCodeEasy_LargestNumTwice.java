import java.util.Arrays;

public class LeetCodeEasy_LargestNumTwice {
	public static void main (String args[]) {
		int[] nums = {-5, 15, 3, 0};
		
		if (nums.length == 1) {
			System.out.println(0);
		}
		
		int max = nums[0];
		int secondMax = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				secondMax = max;
				max = nums[i];
				maxIndex = i;
			} else {
				if (nums[i] > secondMax) {
					secondMax = nums[i];
				}
			}
		}
		
		if (max >= 2 * secondMax) {
			System.out.println(maxIndex);
		} else {
			System.out.println(-1);
		}
	}
}
