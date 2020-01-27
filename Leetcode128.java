import java.util.HashMap;

public class Leetcode128 {

	public static void main(String[] args) {
		int[] nums = {100,1,4,50,2,3,101,7,102,6,5};
		
		HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int left = 0;
            int right = 0;
            int sum = 0;
            
            if (!hm.containsKey(n)) {
                left = hm.getOrDefault(n-1, 0);
                right = hm.getOrDefault(n+1, 0);
                sum = left+right+1;
                
                hm.put(nums[i], sum);
                hm.put(nums[i] - left, sum);
                hm.put(nums[i] + right, sum);
            }
            
            if (max < sum) {
                max = sum;
            }
        }
        
        System.out.println("Longest consecutive subsequence: " + max);
	}

}
