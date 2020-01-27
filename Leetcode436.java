import java.util.Arrays;
import java.util.Comparator;

public class Leetcode436 {

	public static void main(String[] args) {
		int[][] intervals = {{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}};
		int[] result = new int[intervals.length];
		Arrays.fill(result, -1);
		int minValue = Integer.MAX_VALUE;

		/* Brute Force */
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals.length; j++) {
				if (i == j) {
					continue;
				}
				if (intervals[j][0] >= intervals[i][1]) {
					if (minValue > intervals[j][0]) {
						result[i] = j;
						minValue = intervals[j][0];
					}
				}
			}
			minValue = Integer.MAX_VALUE;
		}

		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

		/* Sorting + Binary Search */
		Arrays.fill(result, -1);
		int[][] sortIntervals = new int[intervals.length][2];
		for (int i = 0; i < intervals.length; i++) {
			sortIntervals[i][0] = intervals[i][0];
			sortIntervals[i][1] = i;
		}

		Arrays.sort(sortIntervals, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < intervals.length; i++) {
			int low = 0;
			int high = sortIntervals.length - 1;
			minValue = Integer.MAX_VALUE;
			
			while (low <= high) {
				int mid = low + (high - low)/2;
				if (sortIntervals[mid][0] == intervals[i][1]) {
					result[i] = sortIntervals[mid][1];
					break;
				} else if (sortIntervals[mid][0] < intervals[i][1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
					if (minValue > sortIntervals[mid][1]) {
						result[i] = sortIntervals[mid][1];
						minValue = sortIntervals[mid][0];
					}
				}
			}
		}
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}