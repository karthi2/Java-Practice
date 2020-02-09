import java.util.Stack;

public class Leetcode20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[";
		System.out.println(isValid(s));
	}

	private static boolean isValid(String s) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty() == true) {
                    return false;
                } else {
                    if ((s.charAt(i) == ')' && st.peek() != '(') ||
                        (s.charAt(i) == ']' && st.peek() != '[') || 
                        (s.charAt(i) == '}' && st.peek() != '{')) {
                        return false;
                    }
                    st.pop();
                }
            }
        }
        
        if (st.isEmpty() == false) {
        	return false;
        }
        
        return true;
	}

}
