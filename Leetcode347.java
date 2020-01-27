import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode347 {
	private static class FreqNode {
		int num;
		int freq;
		
		FreqNode (int _num, int _freq) {
			num = _num;
			freq = _freq;
		}
	}
	
	static class FreqComparator implements Comparator<FreqNode> {
		@Override
		public int compare(FreqNode o1, FreqNode o2) {
			// TODO Auto-generated method stub
			return o2.freq - o1.freq;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1,3,2,1,1};
		int k = 2;
		
		Comparator<FreqNode> freqComparator = new FreqComparator();
		PriorityQueue<FreqNode> pq = new PriorityQueue<>(freqComparator);
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
		}
		
		for (Integer keys : hm.keySet()) {
			FreqNode node = new FreqNode(keys, hm.get(keys));
			pq.add(node);
		}
		
		System.out.println(pq.size());
		for (int i = 0; i < k; i++) {
			FreqNode node = pq.poll();
			System.out.println(node.num + ":" + node.freq);
		}
	}

}
