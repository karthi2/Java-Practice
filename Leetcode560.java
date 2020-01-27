public class Leetcode560 {	
	public static void main(String[] args) {
		int[] nums = {5,9,2,3,8,12,1};
		int sum = 14;
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				sum = sum - nums[j];
				if (sum == 0) {
					count++;
				}
			}
			sum = 14;
		}
		System.out.println(count);
	}

}
