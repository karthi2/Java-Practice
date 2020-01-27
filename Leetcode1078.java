import java.util.ArrayList;
import java.util.List;

public class Leetcode1078 {

	public static void main(String[] args) {
		String text = "we will we will rock you";
		String first = "we";
		String second = "will";
		List<String> list = new ArrayList<String>();
		
		String s = first + " " + second + " ";
        int len = s.length();
        int index;
        while ((index = text.indexOf(s)) != -1) {
        	if (index > 0) {
                if (text.charAt(index-1) != ' ') {
                    text = text.substring(index + len);
                    continue;
                }
            }
        	text = text.substring(text.indexOf(s) + len);
        	if (text.indexOf(" ") == -1) {
        		list.add(text);
        	} else {
        		list.add(text.substring(0, text.indexOf(" ")));
        	}
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(i);
        	System.out.println(result[i]);
        }
	}

}
