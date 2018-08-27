
public class WaterTrap {
	public static void main (String args[]) {
		int[] a = {0, 1, 0, 0, 0, 10, 2, 1, 0, 1, 3, 2, 1, 2, 5};
		int startIndex = 0;
		int endIndex = 0;
		int sum = 0;
		int waterTrap = 0;

		int i = 0;
		int j = 0;
		while (a[i] == 0) {
			i++;
		}

		startIndex = i;

		for (; i < a.length - 1; i = Integer.max(i+1, j)) {
			if (a[i + 1] <= a[i]) {
				if (startIndex == -1) {
					startIndex = i;
				}
				sum += a[i + 1];
			} else {
				j = i + 1;
				while ((j + 1) < a.length) {
					if (a[j+1] > a[j]) {
						sum += a[j];
						j++;
					} else {
						break;
					}
				}
				
				endIndex = j;
				try {
					waterTrap += (endIndex - startIndex - 1) * Integer.min(a[endIndex], a[startIndex]) - sum;
				} catch (Exception e) {
					System.out.println(endIndex + " " + startIndex + " " + waterTrap);
					e.printStackTrace();
					return;
				}
				
				sum = 0;
				startIndex = -1;
				endIndex = -1;
			}
		}

		System.out.println(waterTrap);
	}
}
