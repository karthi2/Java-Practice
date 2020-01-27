
public class Leetcode223 {
	public static void main (String[] args) {
		int A = -2;
		int B = -2;
		int C = 2;
		int D = 2;
		int E = 3;
		int F = 3;
		int G = 4;
		int H = 4;
		
		int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        int interX1 = Math.min(C, G);
        int interX2 = Math.max(A, E);
        int interY1 = Math.min(D, H);
        int interY2 = Math.max(B, F);
        int interArea = 0;
        
        if ((interX1 < interX2) || (interY1 < interY2)) {
            interArea = 0;
        } else {
            interArea = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
        
        System.out.println(area1 + area2 - interArea);
	}
}
