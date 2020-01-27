
public class Leetcode441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int count = 0;
		int j = 1;
		
		while (n >= 0) {
			if (n - j >= 0) {
				count++;
			}
			n = n - j;
			j++;
		}
        
        
        System.out.println(count);
	}

}
