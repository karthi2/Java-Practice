import java.util.Arrays;

public class Leetcode1005 {
	public static void main (String[] args) {
		int K = 3;
		int[] A = {3,-1,0,2};
		Arrays.sort(A);
        int sum = 0;
        
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
            } else if (A[i] == 0) {
                i = K;
            } else {
                if ((i-1) >= 0) { //If you have a neg number prev to this, use it
                    if (Math.abs(A[i-1]) > A[i]) {
                        if ((K-i) % 2 == 1) {
                            A[i] = -A[i];
                        }
                    } else {
                        if ((K-i) % 2 == 1) {
                            A[i-1] = -A[i-1];
                        }
                    }
                    i = K;
                } else {
                    if ((K-i) % 2 == 1) {
                        A[i] = -A[i];
                    }
                    i = K;
                }
            }
        }
        
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        
        System.out.println(sum);
	}
}
