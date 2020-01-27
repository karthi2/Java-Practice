
public class Leetcode1011 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {3,2,2,4,1,4};
		int max = Integer.MIN_VALUE;
		int D = 4;
		
		int sum = 0;
		for (int w : weights) {
			sum += w;
			if (max < w) {
				max = w;
			}
		}

		int minWeight = Math.max((int) Math.ceil(sum/D), max);
		int nDays = 0;
		sum = 0;

		while (true) {
			for (int w : weights) {
				if ((sum + w) > minWeight) {
					nDays++;
					sum = w;
				} else {
					sum += w;
				}
			}
			nDays++; //Ship out the last remaining "sum"

			if (nDays <= D) {
				break;
			}
			minWeight++;
			nDays = 0;
			sum = 0;
		}
		
		System.out.println(minWeight);
	}
}
