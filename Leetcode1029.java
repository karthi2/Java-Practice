import java.util.Arrays;

public class Leetcode1029 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
		
		Arrays.sort(costs, (int[] o1, int[] o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));

		for (int i = 0; i < costs.length; i++) {
			System.out.println(costs[i][0] + ", " + costs[i][1]);
		}
		
		int minCost = 0;
		for (int i = 0; i < costs.length; i++) {
			if (i < costs.length/2) {
				minCost += costs[i][0];
			} else {
				minCost += costs[i][1];
			}
		}
		
		System.out.println(minCost);
	}
}
