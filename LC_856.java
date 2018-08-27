import java.util.HashMap;

public class LC_856 {
    //int score = 0;
    int count = 0;
    
    public int scoreOfParentheses(String s) {
    		int score = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (s.charAt(i) == ')') {
            count++;
            i--;
        }
            
        count--;
        if (count == 0) {
            //System.out.println(s.substring(0, i) + " " + score);
            score += 1 + scoreOfParentheses(s.substring(0, i));
        } else {
        		if (score == 0) {
        			score = 1;
        		}
        		
            if ((i-1) >= 0 && s.charAt(i-1) == '(') {
                //System.out.println(s.substring(0, i) + " " + score);
                score = 2 * score;
                score = score + scoreOfParentheses(s.substring(0, i));
            } else {
                //System.out.println(s.substring(0, i) + " " + score);
                score += 1 + scoreOfParentheses(s.substring(0, i));
            }
        }
        
        HashMap<String, String> hm = new HashMap<>();
        String key = new String("Hello");
        String value = new String("World");
        hm.put(key, value);
        
        String val = hm.get(key);
        if (val == value) {
        		System.out.println("True");
        } else {
        		System.out.println("False");
        }
        
        
        //System.out.println(score);
        return score;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC_856 lc = new LC_856();
		String s = new String("(()(()))");
		System.out.println(lc.scoreOfParentheses(s));
	}
}
