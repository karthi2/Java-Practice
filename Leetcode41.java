
public class Leetcode41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,4,2,1,9,10};
		int i = 0;
		
		for (i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
				int tmp = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = tmp;
			}
		}
		
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != (i+1)) {
				break;
			}
		}
		
		System.out.println(i+1);
	}
}
