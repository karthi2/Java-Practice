import java.util.Stack;

public class LeetCodeEasy_FloodFill {
	private class StackObj {
		int sr;
		int sc;
		
		public StackObj(int i, int j) {
			// TODO Auto-generated constructor stub
			sr = i;
			sc = j;
		}
	}
	
	
	public static void main (String args[]) {
		LeetCodeEasy_FloodFill floodFill = new LeetCodeEasy_FloodFill();
		int[][] image = {{1, 1, 1},
						{1, 1, 0},
						{1, 0, 1}
		};
		
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		
		int m = image.length;
		int n = image[m-1].length;
		
		int[][] auxArray = new int[m][n];
		
		Stack<StackObj> stack = new Stack<>();
		stack.push(floodFill.new StackObj(sr, sc));
		auxArray[sr][sc] = 1;
		
		while (!stack.isEmpty()) {
			StackObj stackObj = stack.pop();
			
			int i = stackObj.sr;
			int j = stackObj.sc;
			
			/*
			 * Add 4 possible directions
			 */
			if ((i - 1) >= 0) {
				if (image[i-1][j] == image[i][j] && auxArray[i-1][j] == 0) {
					stack.push(floodFill.new StackObj(i-1, j));
					auxArray[i-1][j] = 1;
				}
			}
			
			if ((i + 1) < m) {
				if (image[i+1][j] == image[i][j] && auxArray[i+1][j] == 0) {
					stack.push(floodFill.new StackObj(i+1, j));
					auxArray[i+1][j] = 1;
				}
			}
			
			if ((j - 1) >= 0) {
				if (image[i][j-1] == image[i][j] && auxArray[i][j-1] == 0) {
					stack.push(floodFill.new StackObj(i, j-1));
					auxArray[i][j-1] = 1;
				}
			}
			
			if ((j + 1) < n) {
				if (image[i][j+1] == image[i][j] && auxArray[i][j+1] == 0) {
					stack.push(floodFill.new StackObj(i, j+1));
					auxArray[i][j+1] = 1;
				}
			}
			
			image[i][j] = newColor;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
}
