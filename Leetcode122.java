
public class Leetcode122 {

	public static void main(String[] args) {
		int[] prices = {2,4,1,5,4,3,5};
		// TODO Auto-generated method stub
		if (prices.length == 0) {
            return;
        }
        
        int localMin = prices[0];
        boolean increasing = false;
        int finalProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                increasing = true;
            } else if (prices[i] < prices[i-1]) {
                if (increasing) {
                    finalProfit += prices[i-1] - localMin;
                    increasing = false;
                }
                localMin = prices[i];
            }
        }
        
        if (increasing) {
            finalProfit += prices[prices.length-1] - localMin;
        }
        
        System.out.println(finalProfit);
	}

}
