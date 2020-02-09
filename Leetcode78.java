import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		subsets(nums, 0, list, result);
		
		int count = 0;
		for (int i = 0; i < result.size(); i++) {
			list = result.get(i);
			for (int k : list) {
				System.out.print(k + " ");
			}
			count++;
			System.out.println();
		}
		System.out.println("Total sets: " + count);
	}

	private static void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		
		if (index > nums.length) {
			return;
		}
		
		result.add(new ArrayList<Integer>(list));
		
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			subsets(nums, i+1, list, result);
			list.remove(list.size()-1);
		}
	}

}
