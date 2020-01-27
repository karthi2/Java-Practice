
public class Leetcode509 {
	public static void main (String[] args) {
		int N = 14;
		if (N == 0 || N == 1) {
            System.out.println(N);
            return;
        }
        
        int a = 0;
        int b = 1;
        int result = -1;
        
        while ((N-2) >= 0) {
            result = b + a;
            a = b;
            b = result;
            N--;
        }
        
        System.out.println(result);
	}
}
