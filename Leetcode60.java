import java.util.ArrayList;
import java.util.List;

public class Leetcode60 {
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 9;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i+1;
		}
		
		List<List<Integer>> result = new ArrayList<>();
		permutationSequence(nums, new ArrayList<Integer>(), result, k);
		
		List<Integer> list = result.get(0);
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void permutationSequence(int[] nums, List<Integer> list, List<List<Integer>> result, int k) {
		// TODO Auto-generated method stub
		if (list.size() == nums.length) {
			count++;
			if (count == k) {
				result.add(new ArrayList<>(list));
				return;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			}
			list.add(nums[i]);
			permutationSequence(nums, list, result, k);
			list.remove(list.size()-1);
		}
	}
}
