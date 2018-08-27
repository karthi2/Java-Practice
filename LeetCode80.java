
public class LeetCode80 {
	private void move (int[] nums, int startIndex, int count, int moveIndex) {
		for (int i = startIndex; moveIndex < nums.length; i++) {
			nums[i] = nums[moveIndex];
			moveIndex++;
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
			return nums.length;
		}

		int count = 1;
		int lastIndex = nums.length;
		int currentIndex = 0;
		int i = 0;

		for (i = 1; i < lastIndex; i++) {
			if (nums[i] == nums[i-1]) {
				count++;
			} else {
				if (count > 2) {
					move(nums, currentIndex+2, count, i);
					lastIndex -= count - 2;
					currentIndex = currentIndex+2;
				} else {
					currentIndex = i;
				}
				i = currentIndex;
				count = 1;
			}
		}

		if (count > 2) {
			move(nums, currentIndex+2, count, i-1);
			lastIndex -= count - 2;
		}

		return lastIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetCode80 lc = new LeetCode80();
		int[] nums = {-50,-50,-49,-48,-47,-47,-47,-46,-45,-43,-42,-41,-40,-40,-40,-40,-40,-40,-39,-38,-38,-38,-38,-37,-36,-35,-34,-34,-34,-33,-32,-31,-30,-28,-27,-26,-26,-26,-25,-25,-24,-24,-24,-22,-22,-21,-21,-21,-21,-21,-20,-19,-18,-18,-18,-17,-17,-17,-17,-17,-16,-16,-15,-14,-14,-14,-13,-13,-12,-12,-10,-10,-9,-8,-8,-7,-7,-6,-5,-4,-4,-4,-3,-1,1,2,2,3,4,5,6,6,7,8,8,9,9,10,10,10,11,11,12,12,13,13,13,14,14,14,15,16,17,17,18,20,21,22,22,22,23,23,25,26,28,29,29,29,30,31,31,32,33,34,34,34,36,36,37,37,38,38,38,39,40,40,40,41,42,42,43,43,44,44,45,45,45,46,47,47,47,47,48,49,49,49,50};
		int len = lc.removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
