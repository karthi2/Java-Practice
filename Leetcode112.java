
public class Leetcode112 {
	static int fn_count = 0;
	static int n = 0;
	private static int step_fn (int start, int num, int j) {
		//System.out.println("# of calls to step_fn: " + ++fn_count);
		int count = 0;
		
		if (num < 0) {
			return 0;
		}
		
		if (num == 0) {
			if (start == 0) {
				return 1;
			}
			return -1;
		}
		
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				start++;
			} else if (i == 1) {
				start--;
			}
			num--;
			//System.out.println(j + "," + i);
			System.out.println(start + "," + num + "," + i);
			int cnt = step_fn(start, num, i);
			if (cnt == -1) {
				num++;
				continue;
			}
			count += cnt;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 3;
		
		System.out.println(step_fn(0, n, 0));
	}

}
