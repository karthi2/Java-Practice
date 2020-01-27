import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode898 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {599,187,674,261,883,475,329,979,17,685,528,538,873,118,361,16,417,353,533,652,916,548,858,1006,688};
		HashSet<List<Integer>> subArrays = new HashSet<>();
		HashSet<Integer> res = new HashSet<Integer>();
		
		getsubArrays(nums, subArrays, new ArrayList<Integer>(), 0);
		
		for (List<Integer> list : subArrays) {
			int bitwiseOr = 0;
			for (Integer i : list) {
				bitwiseOr = bitwiseOr | i;
			}
			res.add(bitwiseOr);
		}
		
		System.out.println(res.size());
	}

	private static void getsubArrays(int[] nums, HashSet<List<Integer>> res, List<Integer> list, int index) {
		// TODO Auto-generated method stub
		if (index > nums.length) {
			return;
		}
		
		if (list.size() > 0) {
			res.add(new ArrayList<>(list));
		}
		
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			getsubArrays(nums, res, list, i+1);
			list.clear();
		}
	}

}
