
public class LeetCodeEasy_MinCostStairs {
	public static void main (String args[]) {
		int[] cost = {0, 0, 1, 1};
		
		if (cost.length == 2) {
			System.out.println(Integer.min(cost[0], cost[1]));
			return;
		}
		
		int[] minCost = new int[cost.length + 1];
		minCost[0] = cost[0];
		minCost[1] = cost[1];
		
		for (int i = 2; i <= cost.length; i++) {
			if (i == cost.length) {
				minCost[i] = Integer.min(minCost[i - 1], minCost[i-2]);
			} else {
				minCost[i] = Integer.min(minCost[i - 1], minCost[i-2]) + cost[i];
			}
		}
		
		System.out.println(minCost[cost.length]);
	}
}
