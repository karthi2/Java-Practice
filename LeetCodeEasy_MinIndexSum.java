import java.util.ArrayList;
import java.util.HashMap;

public class LeetCodeEasy_MinIndexSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list1 = {"Burger King", "Shogun", "KFC", "Tapioca Express"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		
		int minSumIndex = Integer.MAX_VALUE;
		ArrayList<String> result = new ArrayList<>();
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < list1.length; i++) {
			hm.put(list1[i], i);
		}
		
		for (int i = 0; i < list2.length; i++) {
			if (hm.containsKey(list2[i])) {
				int val = hm.get(list2[i]);
				
				if ((val + i) < minSumIndex)  {
					minSumIndex = val + i;
					result.clear();
					result.add(list2[i]);
				} else if ((val + i) == minSumIndex) {
					result.add(list2[i]);
				}
			}
		}
		
		System.out.println(result);
	}

}
