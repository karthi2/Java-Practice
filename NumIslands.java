
public class NumIslands {
    static void dfs (char[][] grid, int[][]visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        
        if (visited[i][j] == 1 || grid[i][j] == '0') {
        		return;
        }
        
        visited[i][j] = 1;
        
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i+1, j);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		
		int count = 0;
		int[][] visited = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        System.out.println(count);
	}

}
