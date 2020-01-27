
public class Leetcode762 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int L = 842;
		int R = 888	;
		
		int i = 0;
	    int count = 0;
	    int result = 0;
	    for (i = L; i <= R; i++) {
	    	int n = i;
	        while (n > 0) {
	        	n = n & (n-1);
	            count++;
	        }
	        
	        switch (count) {
	            case 2:
	            case 3:
	            case 5:
	            case 7:
	            case 11:
	            case 13:
	            case 17:
	            case 19:
	            case 23:
	            case 29:
	            case 31:
	                result++;
	                break;
	            default:
	                break;
	        }
	        count = 0;
	    }
	    System.out.println(result);
	}
}
