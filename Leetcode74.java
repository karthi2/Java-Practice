
public class Leetcode74 {
	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7}, 
						  {10, 11, 16, 20}, 
						  {23, 30, 34, 50}};

		int target = -4;

		if (matrix.length == 0) {
			System.out.println(false);
		}

		int rLen = matrix.length;
		int cLen = matrix[0].length;

		int low = 0;
		int high = rLen - 1;
		int row = -1;

		if ((target > matrix[rLen-1][cLen-1]) || (target < matrix[0][0])) {
			System.out.println(false);
			return;
		}
		
		/* Column search */
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			
			if (matrix[mid][cLen-1] == target) {
				System.out.println(true);
				return;
			}
			
			if ((matrix[mid][cLen - 1] <= target) && (target <= matrix[mid+1][cLen - 1])) {
				row = mid+1;
				break;
			} else if (target < matrix[mid][cLen - 1]) {
				high = mid - 1;
			} else if (target > matrix[mid][cLen - 1]) {
				low = mid + 1;
			}
		}
		
		if (low > high) {
			row = low;
		}

		/* Row search */
		low = 0;
		high = cLen - 1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (matrix[row][mid] == target) {
				System.out.println(true);
				return;
			}

			if (matrix[row][mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(false);
	}
}
