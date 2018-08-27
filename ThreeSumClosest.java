
public class ThreeSumClosest {
	private static int threeSumCloset (int[] a, int target) {
		if (a.length == 0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 2; i++) {
            int sum = target - a[i];
            
            for (int j = i + 1; j < a.length - 1; j++) {
                if ((Math.abs(sum - (a[j] + a[j + 1]))) < min) {
                    min = Math.abs(sum - (a[j] + a[j + 1]));
                }
            }
        }
        
        return min+target;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1, 2, 1, -4};
		int target = 1;
		
		System.out.println(threeSumCloset(a, target));
	}

}
