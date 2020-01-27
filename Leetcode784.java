import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode784 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "C";
		s = s.toLowerCase();
		
		List<String> res = letterCasePermutation(s);
		for (String st : res) {
			System.out.println(st);
		}
	}

	private static List<String> letterCasePermutation(String s) {
		// TODO Auto-generated method stub
		Queue<String> q = new LinkedList<>();
        q.add(s);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
            	int size = q.size();
            	for (int j = 0; j < size; j++) {
	                String string = q.poll();
	                char[] ch = string.toCharArray();
	                
	                ch[i] = Character.toUpperCase(ch[i]);
	                q.add(new String(ch));
	                ch[i] = Character.toLowerCase(ch[i]);
	                q.add(new String(ch));
            	}
            }
        }
        
        List<String> list = new ArrayList<String>(q);
        return list;
	}

}
