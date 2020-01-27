
public class Leetcode896 {

	public static void main(String[] args) {
		int[] A = {5,6,3,2,1,1};
		int len = A.length;
        if (len == 1) {
        	System.out.println(true);
            return;
        }
        
        boolean increasing = false;
        int i = 0;
        
        for (i = 0; i < len-1; i++) {
            if (A[i+1] == A[i]) {
                continue;
            } else if (A[i+1] > A[i]) {
                increasing = true;
            }
            break;
        }
        
        if (increasing) {
            for (int j = i; j < len-1; j++) {
                if (A[j+1] < A[j]) {
                	System.out.println(false);
                    return;
                }
            }
        } else {
            for (int j = i; j < len-1; j++) {
                if (A[j+1] > A[j]) {
                    System.out.println(false);
                    return;
                }
            }
        }
        
        System.out.println(true);
	}

}
