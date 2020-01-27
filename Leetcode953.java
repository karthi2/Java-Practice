
public class Leetcode953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve",
						"miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
		String order = "zkgwaverfimqxbnctdplsjyohu";
		
        
        if (words.length == 1) {
            System.out.println(true);
            return;
        }
        
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i-1];
            String s2 = words[i];
            int j = 0;
            int k = 0;
            
            while (j < s1.length() && k < s2.length()) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(k);
                
                if (order.indexOf(c1) < order.indexOf(c2)) { 
                    break;
                } else if (order.indexOf(c1) > order.indexOf(c2)) {
                    System.out.println(false);
                    return;
                }
                j++;
                k++;
            }
            
            if (j < s1.length() && k == s2.length()) {
                System.out.println(false);
                return;
            }
        }
        
        System.out.println(true);
	}
}
