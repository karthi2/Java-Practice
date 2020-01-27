
public class Leetcode42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {0};
		Leetcode42 obj = new Leetcode42();
		System.out.println(obj.trap(heights));
		
	}

	
	public int trap(int[] height) {
		if (height.length < 3) {
            return 0;
        }
        
        int x = 0;
        int y = 0;
        int z = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int trapped = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        
        int j = 0;
        int heights = 0;
        int startIndex = 0;
        int endIndex = 0;
        if (maxIndex > 1) {
            while (j < maxIndex && (j+2) < height.length) {
                x = height[j];
                y = height[j+1];
                z = height[j+2];
                startIndex = j;
                endIndex = j+2;
                heights = y;
                
                if (x > y) {
                	while (true) {
	                	if (z >= x) {
	                		trapped += (Math.min(x, z) * (endIndex - startIndex - 1)) - heights;
	                		j = endIndex;
		                    break;
	                	} else {
	                		endIndex++;
	                		heights += z;
	                		z = height[endIndex];
	                	}
                	}
                } else {
                	j++;
                }
            }
        }
        
        if ((height.length - 1 - maxIndex) > 1) {
            j = height.length - 1;
            while (j > maxIndex && (j-2) >= 0) {
            	x = height[j];
                y = height[j-1];
                z = height[j-2];
                startIndex = j;
                endIndex = j-2;
                heights = y;
                
                if (x > y) {
                	while (true) {
	                	if (z >= x) {
	                		trapped += (Math.min(x, z) * (startIndex - endIndex - 1)) - heights;
	                		j = endIndex;
		                    break;
	                	} else {
	                		endIndex--;
	                		heights += z;
	                		z = height[endIndex];
	                	}
                	}
                } else {
                	j--;
                }
            }
        }
        return trapped;
    }
}
