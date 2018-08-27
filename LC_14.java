import java.util.ArrayList;
import java.util.List;

public class LC_14 {
	public static void main(String[] args) {
		LC_14 lc14 = new LC_14();
		String strs[] = new String[3];
		
		strs[0] = "flower";
		strs[1] = "flow";
		strs[2] = "flight";
		
		lc14.longestCommonPrefix(strs);
	}

	private void longestCommonPrefix(String[] strs) {
		// TODO Auto-generated method stub
		if (strs == null) {
            System.out.println("");
        }
        
        int k = 0;
        for (int i = 1; i < strs.length; i++) {
            if ((k == strs[i].length()) || (strs[0].charAt(k) != strs[i].charAt(k))) {
                break;
            }
        }
        
        System.out.println(strs[0].substring(k));
        
        
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("this");
        String[] res = (String[]) list.toArray(new String[0]);
        for (String r : res) {
        		System.out.println(r);
        }
	}

}
