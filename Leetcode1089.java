public class Leetcode1089 {

	public static void main(String[] args) {
		int[] arr = {8,4,5,0,0,0,0,7};
		int len = arr.length;
        int trackIndex = -1;
        int newLength = 0;
        
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                newLength += 2;
            } else {
                newLength++;
            }
            
            if (newLength == len || newLength > len) {
                trackIndex = i;
                break;
            }
        }
        
        for (int i = trackIndex; i >= 0 && len > 0; i--) {
            if (arr[i] == 0) {
                arr[len-1] = arr[i];
                len--;
                if (trackIndex == i && newLength > arr.length) {
                	continue;
                }
            }
            
            arr[len-1] = arr[i];
            len--;
        }
        
        for (int i = 0; i < arr.length; i++) {
        	System.out.print(arr[i] + " ");
        }
	}
}
