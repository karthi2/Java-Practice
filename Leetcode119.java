import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode119 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowIndex = 3;
		List<Integer> result = new ArrayList<Integer>();
        result.add(0, 1);
        result.add(1, 1);
        
        for (int i = 2; i <= rowIndex; i++) {
        	result = getRow(i, result);
        }
        Integer[] a = result.toArray(new Integer[0]);
        Arrays.sort(a, Collections.reverseOrder());
        
		for (int k = 0; k < result.size(); k++) {
            System.out.print(result.get(k) + " ");
        }
	}

	private static List<Integer> getRow(int rowIndex, List<Integer> input) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int j = 1; j < rowIndex; j++) {
        	result.add(j, input.get(j-1)+input.get(j));
            System.out.println("j = " + j + ", val = " + result.get(j) + " ");
        }
        
        result.add(1);
        return result;
	}

}