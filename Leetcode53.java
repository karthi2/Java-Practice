
public class Leetcode53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-3,4,8,2,1,-5,4};
		int[] dp = new int[nums.length];
		
		dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[i-1] && dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //System.out.print(dp[i] + " "); 
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
	}

}
