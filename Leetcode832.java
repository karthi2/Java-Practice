
public class Leetcode832 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		int rLen = A.length;
        int cLen = A[0].length;
        
        for (int i = 0; i < rLen; i++) {
        	int k = cLen - 1;
            for (int j = 0; j < cLen/2; j++) {
            	int temp = A[i][j];
            	A[i][j] = A[i][k];
            	A[i][k] = temp;
                k--;
            }
        }
        
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                A[i][j] = (A[i][j] == 0) ? 1:0;
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
	}
}
