
public class Celebrity {
	public static boolean haveAquaintance () {
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * T(n) = T(n - 1) + n
		 * Base case: 
		 */
		/*
		int n = Integer.parseInt(args[1]);
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (haveAquaintance(a[i], a[j])) {
					graph[i][j] = 1;
				}
			}
		}
		
		boolean found = true;
		int celebrityIndex = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (graph[i][j] != 0) {
						found = false;
						break;
					}
				}
			}
			
			if (found == false) {
				found = true;
				continue;
			} else {
				celebrityIndex = i;
				break;
			}
		}
		
		for (int i = 0; i < )
		*/
	}

}