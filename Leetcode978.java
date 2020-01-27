
public class Leetcode978 {
	public static void main(String[] args) {
		int[] A = {0,1,1,0,1,0,1,1,0,0};
		
		if (A.length == 1) {
            System.out.println(A.length);
            return;
        }
        
        int res = 0;
        int maxLen = 1;
        char c = ' ';
        boolean restart = true;
        
        for (int i = 1; i < A.length; ) {
            if (restart) {
                if (A[i] < A[i-1]) {
                    c = '>';
                } else if (A[i] > A[i-1]) {
                    c = '<';
                }
                
                if (c == '<' || c == '>') {
	                maxLen++;
	                restart = false;
                }
                i++;
                continue;
            }
            
            if ((A[i] < A[i-1] && c == '<') || (A[i] > A[i-1] && c == '>')) {
            	c = (c == '>') ? '<' : '>';
            	maxLen++;
            	i++;
            } else {
            	if (maxLen > res) {
                    res = maxLen;
                }
                maxLen = 1;
                c = ' ';
                restart = true;
            }
        }
        
        System.out.println(res > maxLen ? res : maxLen);
	}
}
