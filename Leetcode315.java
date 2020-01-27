import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,2,6,1};
		Integer[] copy = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		
		List<Integer> copyList = Arrays.asList(copy);
		
		Arrays.sort(copy);
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			int index = copyList.indexOf(new Integer(nums[i]));
			System.out.println(index);
			result.add(index);
		}
		
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}

}
