import java.util.LinkedList;
import java.util.List;

public class BracketGeneration {
	private static void brackets (int i, int j, String s, List list) {
        if (j == 0) {
        		//System.out.println(s);
        		list.add(s);
            return;
        }

        if (i != 0) {
            brackets(i-1, j, s + '(', list);
        }

        if (j > i) {
            brackets(i, j - 1, s + ')', list);
        }
    }

	private static void generateParanthesis (int n) {
		List<String> list = new LinkedList<>();
		brackets(n, n, "", list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
    public static void main (String args[]) {
        int n = 4;
        generateParanthesis(n);
    }
}
