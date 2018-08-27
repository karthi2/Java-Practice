
public class LC581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        int startIndex = -1;
        int endIndex = -1;
        int maxIndex = 0;
        int minIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                if (max <= nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            } else if (nums[i-1] >= nums[i]) {
                if (min > nums[i]) {
                    min = nums[i];
                    minIndex = i;
                }
                
                if (startIndex == -1) {
                    startIndex = i-1;
                }
                endIndex = i;
            }
        }
        
        if (minIndex > startIndex) {
            startIndex = 0;
        }
        
        if (maxIndex < nums.length - 1) {
            endIndex = nums.length - 1;
        }
        
        System.out.println(minIndex + " " + maxIndex + " " + startIndex + " " + endIndex);
        return endIndex - startIndex + 1;
    }
    
	public static void main(String[] args) {
		LC581 lc581 = new LC581();
		int[] nums = {1,2,3,4,4};
		
		System.out.println(lc581.findUnsortedSubarray(nums));
	}

}
