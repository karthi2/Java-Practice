
public class LeetCodeEasy_ReshapeMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        int k = 0;
        
        if (m * n != r * c) {
            return nums;
        }
        
        int[] arr = new int[m * n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = nums[i][j];
            }
        }
        
        k = 0;
        int[][] out = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                out[i][j] = arr[k++];
            }
        }
        
        return out;
    }
	
	public static void main (String args[]) {
		
	}
}
