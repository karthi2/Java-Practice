
public class RotateMatrix {
	public static void main (String args[]) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int i = 0;
        int j = 0;
        
        int n = a.length;
        int temp;
        
        
        
        for (i = 0; i < n; i++) {
        		for (j = 0; j < n; j++) {
        			System.out.print(a[i][j] + " ");
        		}
        		System.out.println();
        }
	}
}
