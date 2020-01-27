import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRows = 1;
		String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
		int len = s.length();
		ArrayList<List<Character>> result = new ArrayList<>();
		List<Character> list;
		int index = 0;
		boolean dir_up = true;
		
		if (numRows == 1) {
			System.out.println(s);
			return;
		}
		
		for (int i = 0; i < numRows; i++) {
			list = new ArrayList<Character>();
			result.add(list);
		}
		
		for (int i = 0; i < len; i++) {
            if (index == numRows) {
                index = index - 2;
                dir_up = false;
            } else if (index == -1)  {
                index = index + 2;
                dir_up = true;
            }
		
			try {
				list = result.get(index);
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				return;
			}
			
	        list.add(s.charAt(i));
	        
	        if (dir_up) {
                index++;
            } else {
                index--;
            }
        }
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
            list = result.get(i);
            Iterator<Character> iter = list.iterator();
            while (iter.hasNext()) {
            	sb.append(iter.next());
            }
        }
		System.out.println(sb.toString());
	}

}
