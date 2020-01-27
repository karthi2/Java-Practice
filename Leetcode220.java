import java.util.Arrays;

public class Leetcode220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 5, 9, 1, 5, 9};
		int k = 2;
		int t = 3;
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((Math.abs(nums[i] - nums[j]) <= t) && Math.abs(i - j) <= k) {
					System.out.println(true);
					return;
				}
				
				if (Math.abs(nums[i] - nums[j]) > t ||
						Math.abs(i - j) > k) {
					break;
				}
			}
		}
		
		System.out.println(false);
	}

}
