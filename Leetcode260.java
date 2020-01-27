public class Leetcode260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1,5,2};
		
		int xor = 0;
	    for (int i = 0; i < nums.length; i++) {
	        xor = xor ^ nums[i];
	    }
	    
	    int mask = 1;
	    while (true) {
	        if ((xor & mask) != 0) {
	        	break;
	        }
	        mask = mask << 1;
	    }
	    
	    int[] result = new int[2];
	    for (int i = 0; i < nums.length; i++) {
	    	if ((nums[i] & mask) == 0) {
	    		result[0] = nums[i] ^ result[0];
	    	} else {
	    		result[1] = nums[i] ^ result[1];
	    	}
	    }
	    
	    System.out.println(result[0] + ", " + result[1]);
	}

}