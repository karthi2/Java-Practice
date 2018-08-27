import java.util.Stack;

public class LeetCodeEasy_IslandArea {
	private class Index {
		Integer m;
		Integer n;
		
		Index (int i, int j) {
			m = i;
			n = j;
		}
	}
	
	public static void main (String args[]) {	
		LeetCodeEasy_IslandArea islandArea = new LeetCodeEasy_IslandArea();
		int numIslands = 0;
		
		int[][]grid = {{1,1,1,1,0},
					   {1,1,0,1,0},
					   {1,1,0,0,0}, 
					   {0,0,0,0,0}};
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][]visited = new int[m][n];
		Stack<Index> stack = new Stack<>();
		int maxArea = 0;
		
		/*
		 * Find the first '1' in the grid and push its indices to the stack
		 */
		for (int mm = 0; mm < m; mm++) {
			for (int nn = 0; nn < n; nn++) {
				if (grid[mm][nn] == 1 && visited[mm][nn] == 0) {
					visited[mm][nn] = 1;
					stack.push(islandArea.new Index(mm, nn));
					
					int area = 0;
					
					while (!stack.isEmpty()) {
						Index index = stack.pop();
						area += 1;
					
						int i = index.m;
						int j = index.n;
						
						if ((j - 1) >= 0 && grid[i][j-1] == 1 && visited[i][j-1] == 0) {
							visited[i][j-1] = 1;
							stack.push(islandArea.new Index(i, j-1));
						}
						
						if ((j + 1) < n && grid[i][j+1] == 1 && visited[i][j+1] == 0) {
							visited[i][j+1] = 1;
							stack.push(islandArea.new Index(i, j+1));
						}
						
						if ((i - 1) >= 0 && grid[i-1][j] == 1 && visited[i-1][j] == 0) {
							visited[i-1][j] = 1;
							stack.push(islandArea.new Index(i-1, j));
						}
						
						if ((i+1) < m && grid[i+1][j] == 1 && visited[i+1][j] == 0) {
							visited[i+1][j] = 1;
							stack.push(islandArea.new Index(i+1, j));
						}
					}
					
					if (area > maxArea) {
						maxArea = area;
					}
					
					
					numIslands++;
					area = 0;
				}
			}
		}

		System.out.println(maxArea + " " + numIslands);
	}
}
