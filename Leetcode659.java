import java.util.HashMap;

public class Leetcode659 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,3,4,4,5,5};
		HashMap<Integer, Integer> freq = new HashMap<>();

		for (int i : nums) {
			freq.put(i, freq.getOrDefault(i, 0)+1);
		}

		HashMap<Integer, Integer> hyp = new HashMap<>();
		for (int i : nums) {
			if (freq.getOrDefault(i, 0) == 0) {
				continue;
			}
			if (hyp.getOrDefault(i, 0) > 0) {
				hyp.put(i, hyp.get(i)-1);
				hyp.put(i+1, hyp.getOrDefault(i+1, 0)+1);
			} else if (freq.getOrDefault(i+1, 0) > 0 && freq.getOrDefault(i+2, 0) > 0) {
				freq.put(i+1, freq.get(i+1)-1);
				freq.put(i+2, freq.get(i+2)-1);
				hyp.put(i+3, hyp.getOrDefault(i+3, 0)+1);
			} else {
				System.out.println(false);
				return;
			}

			freq.put(i, freq.get(i)-1);
		}
		
		System.out.println(true);
	}

}