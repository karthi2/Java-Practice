public class Leetcode1232 {
	public static void main (String[] args) {
		int[][] coordinates = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		int leni = coordinates.length;

		if (leni == 1 || leni == 2) {
			System.out.println(true);
		}

		/************************
		(s - q) * (x - r) = (y - s) * (r - p)
		 ************************/


		int p = coordinates[0][0];
		int q = coordinates[0][1];
		int r = coordinates[1][0];
		int s = coordinates[1][1];

		for (int i = 0; i < leni; i++) {
			int x = coordinates[i][0];
			int y = coordinates[i][1];
			if ((s-q) * (x-r) != (y-s) * (r-p)) {
				System.out.println(false);
			}
		}

		System.out.println(true);
	}
}
