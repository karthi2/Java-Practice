
public class LeetCodeEasy_ShortestUnsortedSubArray {
	public static void main (String args[]) {
		int nums[] = {2, 4, 3, 5, 8, 9, 1};
		
		int i = 0;
		int j = nums.length - 1;
		int startIndex = -1;
		int endIndex = -1;
		
		while (i < j) {
			if (nums[i] > nums[i+1]) {
				startIndex = i;
				break;
			}
			i++;
		}
		
		while (j > i) {
			if (nums[j] < nums[j -1]) {
				endIndex = j;
				break;
			}
			j--;
		}
		
		
		System.out.println(endIndex - startIndex + 1);
	}
}
