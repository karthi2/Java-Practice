
public class Leetcode4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		double median = 0;
		
		int m = arr1.length;
		int n = arr2.length;
		
		if (m == 0) {
			if (n % 2 == 0) {
				median = (double)(arr2[n/2] + arr2[n-1/2])/2;
			} else {
				median = arr2[n/2];
			}
			return;
		} else if (n == 0) {
			if (m % 2 == 0) {
				median = (arr2[m/2] + arr2[m-1/2])/2;
			} else {
				median = arr2[m/2];
			}
			return;
		}
		
		int i = 1;
		int j = (m + n + 1)/2 - i;
		
		while (j >= n) {
			i++;
			j = (m + n + 1)/2 - i;
		}
		
		while ((i < m && j < n && !(arr1[i-1] <= arr2[j] && arr2[j-1] <= arr1[i]))) {
			if (arr1[i-1] > arr2[j]) {
				i--;
			} else if (arr2[j-1] > arr1[i]) {
				i++;
			}
			j = (m + n + 1)/2 - i;
		}
		
		if ((m+n)%2 == 0) {
			median = (double) (Math.max(arr1[i-1], arr2[j-1]) + Math.min(arr1[i], arr2[j]))/2;
		} else {
			median = Math.max(arr1[i-1], arr2[j-1]);
		}
		
		System.out.println(median);
	}
}
