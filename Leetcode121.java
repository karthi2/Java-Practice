
public class Leetcode121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		int min = prices[0];
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				profit = Math.max(profit, prices[i] - min);
			}
		}
		
		System.out.println(profit);
	}

}
