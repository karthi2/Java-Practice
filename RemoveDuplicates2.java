
public class RemoveDuplicates2 {
	public static void main (String args[]) {
		int[] a = {3, 4, 5, 5, 6, 6};
		int newIndex = 1;
		int lastSeen = a[0];
		
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] != a[i + 1] && lastSeen != a[i]) {
				a[newIndex++] = a[i];
				lastSeen = a[i];
			}
		}
		a[newIndex++] = a[a.length - 1];
		
		for (int i = 0; i < newIndex; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
