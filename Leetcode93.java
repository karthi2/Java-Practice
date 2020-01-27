import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "10101010";
		List<String> res = new ArrayList<>();
		
		res = restoreIpAddresses(s);
		for (String st : res) {
			System.out.println(st);
		}
	}

	private static List<String> restoreIpAddresses(String s) {
		// TODO Auto-generated method stub
		int len = s.length();
        if (len < 4) {
            return null;
        }
        
        List<String> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<String>();
        
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3 && j < len; j++) {
                for (int k = 1; k <= 3 && k < len; k++) {
                    int l = len-(i+j+k);
                    if (l <= 0 || l > 3) {
                    	continue;
                    }
                    
                    if ((i+j+k+l) == len) {
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, i+j);
                        String s3 = s.substring(i+j, i+j+k);
                        String s4 = s.substring(i+j+k);
                        
                        if (isValid(s1, hs) && isValid(s2, hs) && isValid(s3, hs) && isValid(s4, hs)) {
                            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
        }
		return res;
	}
	
	private static boolean isValid (String s, HashSet<String> hs) {
		if (hs.contains(s)) {
			return true;
		}
		
        if (s.length() > 0 && s.length() <= 3 && Integer.parseInt(s) <= 255 && !(s.startsWith("0") && s.length() > 1)) {
        	hs.add(s);
        	return true;
        }
        
        return false;
    }

}
