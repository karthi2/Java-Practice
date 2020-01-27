import java.util.Arrays;

public class Leetcode1051 {

	public static void main(String[] args) {
		int[] heights = {1,1,4,2,1,3};
		int[] sortHeights = Arrays.copyOf(heights, heights.length);
		Arrays.sort(sortHeights);
		int count = 0;
		
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != sortHeights[i]) {
				count++;
			}
		}
		
		System.out.println(count);
		
		/* Another way */
		count = 0;
		int[] dp = new int[101];
		for (int i = 0; i < heights.length; i++) {
			dp[i]++;
		}
		
		int len = heights.length - 1;
		for (int i = dp.length-1; i >= 0; i--) {
			while (dp[i] != 0) {
				if (dp[i] != heights[len]) {
					count++;
				}
				dp[i]--;
				len--;
			}
		}
		System.out.println(count);
	}

}
