
public class LC738 {
	public int monotoneIncreasingDigits(int N) {
		int firstEqual = -1;

		String num = Integer.toString(N);
		char[] arr = num.toCharArray();

		for (int j = 0; j < arr.length-1; j++) {
			if (arr[j] == arr[j+1]) {
				if (firstEqual == -1) {
					firstEqual = j;
				}
			} else if (arr[j] > arr[j+1]) {
				if (firstEqual == -1) {
					arr[j] -= 1;
				} else {
					arr[firstEqual] -= 1;
					j = firstEqual;
				}

				j++;
				for (; j < arr.length; j++) {
					arr[j] = '9';
				}

				return Integer.parseInt(String.valueOf(arr));
			} else {
				firstEqual = -1;
			}
		}
		
		return N;
	}

	public static void main(String[] args) {
		LC738 lc738 = new LC738();

		System.out.println(lc738.monotoneIncreasingDigits(334565848));
	}

}
