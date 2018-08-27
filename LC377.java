public class LC377 {
	public int combinationSum4(int[] nums, int target) {
		if (target == 0) {
	        return 1;
	    }
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (target >= nums[i]) {
	            res += combinationSum4(nums, target - nums[i]);
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		LC377 lc377 = new LC377();
		
		int target = 3;
		int[] nums = {1, 1, 2, 3};
		int res = lc377.combinationSum4(nums, target);
		
		System.out.println(res);

	}

}
