import java.util.Arrays;

public class Leetcode55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 0, 0};
		int len = nums.length;
		int[] dp = new int[len];
		Arrays.fill(dp, 0);
		
		if (len == 1) {
			System.out.println(true);
			return;
		}
		
		for (int i = len - 2; i >= 0; i--) {
			if (((nums[i] + i) >= len - 1)) {
				dp[i] = 1;
				continue;
			}
			
			for (int j = 1; j <= nums[i]; j++) {
				if (nums[i] > 0 && (i+j) < len && dp[i+j] == 1) {
					dp[i] = 1;
					break;
				}
			}
		}
		
		if (dp[0] == 1) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
