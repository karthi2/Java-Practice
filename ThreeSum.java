import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main (String arge[]) {
		int[] a = {-1, 0, 1, -1, 2, -4};

        if (a.length == 0) {
            return;
        }
        
        Arrays.sort(a);
        
        List<List<Integer>> result = new LinkedList<>();
        
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) {
                break;
            }
            
            if (i!= 0 && a[i] == a[i-1]) {
            		/*
            		 * Print the results and return
            		 */
            		return;
            }
            
            int sum = 0 - a[i];
            int low = i + 1;
            int high = a.length - 1;
            
            while (low < high) {
                if (a[low] + a[high] == sum) {
                    Integer[] arr = {sum, a[low], a[high]};
                    result.add(Arrays.asList(arr));
                    low++;
                    high--;
                } else if (a[low] + a[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
	}
}
