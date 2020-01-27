import java.util.Arrays;

public class Leetcode43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "999999999999999999";
		String s2 = "9999999999999999999999999";
		
		if (s1.equals("0") || s2.equals("0")) {
            System.out.println("0");
            return;
        }
        
        if (s1.equals("1")) {
        	System.out.println(s2);
            return;
        }
        
        if (s2.equals("1")) {
        	System.out.println(s1);
            return;
        }
		
		int len1 = s1.length();
		int len2 = s2.length();
		char[] res = new char[len1+len2];
		Arrays.fill(res, ' ');
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int i = 0;
		int j = 0;
		int k = len1 + len2 - 1;
		int l = k;
		int carry = 0;
		
		for (i = len1 - 1; i >= 0; i--) {
			int a = c1[i] - '0';
			for (j = len2 - 1; j >= 0; j--) {
				int b = c2[j] - '0';
				
				int resk = 0;
				if (res[k] != ' ') {
					resk = res[k] - '0';
				}
				int prod = (a * b) + resk + carry;
				carry = prod / 10;
				prod = prod % 10;
				res[k] = Character.forDigit(prod, 10);
				k--;
			}
			
			if (carry > 0) {
				res[k] = Character.forDigit(carry, 10);
				carry = 0;
			}
			l--;
			k = l;
		}
		
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < res.length; i++) {
			if (res[i] != ' ') {
				sb.append(res[i]);
			}
		}
		System.out.println(sb.toString());
	}

}
