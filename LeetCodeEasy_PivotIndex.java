
/*
 * Not working
 */
public class LeetCodeEasy_PivotIndex {
	public static void main (String args[]) {
		int[] nums = {1, 2, -997, -1, -343, 2, 1, -654};
		
		int i = 0;
		int j = nums.length - 1;
		
		int leftSum = nums[i];
		int rightSum = nums[j];
				
		while (i < j) {
			if (rightSum == leftSum) {
				if (i + 2 == j) {
					System.out.println(i+1);
					return;
				}
				i++;
				j--;
				
				leftSum += nums[i];
				rightSum += nums[j];
			} else if (rightSum < leftSum){
				j--;
				rightSum += nums[j];
			} else if (rightSum > leftSum) {
				i++;
				leftSum += nums[i];
			}
		}
		
		System.out.println(-1);
	}
}