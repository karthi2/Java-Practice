
public class Rob {

	public static void main(String[] args) {
		int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		
		if (nums.length == 0) {
            System.out.println(0);;
        }
        
        System.out.println(findmax(nums, 0, nums.length - 1));
	}

	private static int findmax(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j - 1) {
            return Math.max(nums[i], nums[j]);
        }
        
        if (i == j) {
        		return nums[i];
        }
        
        return Math.max(nums[i] + findmax(nums, i + 2, j), findmax(nums, i+1, j));
	}

}
