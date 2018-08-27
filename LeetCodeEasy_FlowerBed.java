
public class LeetCodeEasy_FlowerBed {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int zeroCount = 0;
		int i = 0;

		for (i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				if (zeroCount >= 2) {
					n = n - zeroCount/2;
					n--;
					if (n <= 0) {
						break;
					}
				}
				zeroCount = 0;
				i++;
			} else {
				zeroCount++;
			}
		}

		if (i == flowerbed.length && zeroCount > 0) {
			while (zeroCount > 0) {
				n--;
				if (n <= 0) {
					break;
				}
				zeroCount -= 2;
			}
		}

		if (n > 0) {
			return false;
		}

		return true;
	}

	public static void main (String args[]) {
		LeetCodeEasy_FlowerBed fb = new LeetCodeEasy_FlowerBed();

		int[] flowerbed = {1,0,0,0,0};
		System.out.println(fb.canPlaceFlowers(flowerbed, 2));
	}
}
