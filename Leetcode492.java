
public class Leetcode492 {
	public static void main (String[] args) {
		long startTime = System.nanoTime();
		int area = 4;
		int range = area/2;
		int length = 0;
		int width = 0;
		int min = Integer.MAX_VALUE;
		
		if (area == 1 || area == 2 || area == 3) {
            length = area;
            width = 1;
        }

		for (int i = 1; i <= range; i++) {
			if (area % i == 0) {
				if (Math.abs(i - area/i) < min) {
					min = Math.abs(i - area/i);
					if (area/i > i) {
						length = area/i;
						width = i;
					} else {
						length = i;
						width = area/i;
					}
				}
				//System.out.println(i + " " + area/i);
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Runtime: " + (endTime - startTime));
		System.out.println(length + " " + width);
	}
}
