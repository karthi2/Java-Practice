
public class Leetcode463 {
	/*
	private static int verifyEdges(int[][] grid, int row, int col) {
        int count = 0;

        if ((col > 0) && (grid[row][col-1] == 0)) {
            count++;
        }

        if ((col < (grid[0].length-1)) && (grid[row][col+1] == 0)) {
            count++;
        }

        if ((row > 0) && (grid[row-1][col] == 0)) {
            count++;
        }

        if ((row < (grid.length-1)) && (grid[row+1][col] == 0)) {
            count++;
        }

        if (row == 0) {
        	count++;
        }

        if (col == 0) {
        	count++;
        }

        if (row == (grid.length-1)) {
        	count++;
        }

        if (col == (grid[0].length-1)) {
        	count++;
        }

        return count;
    }*/

	private static int verifyEdges (int[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || (grid[i][j] == 0)) {
			return 1;
		}

		return 0;
	}

	public int islandPerimeter(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count = count + verifyEdges(grid, i-1, j, grid.length, grid[0].length);
					count = count + verifyEdges(grid, i+1, j, grid.length, grid[0].length);
					count = count + verifyEdges(grid, i, j-1, grid.length, grid[0].length);
					count = count + verifyEdges(grid, i, j+1, grid.length, grid[0].length);
				}
			}
		}

		return count;
	}

	public static void main (String[] args) {
		int[][] grid = {{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}};
		Leetcode463 obj = new Leetcode463();
		System.out.println(obj.islandPerimeter(grid));
	}
}
