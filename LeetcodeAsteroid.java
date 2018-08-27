import java.util.Iterator;
import java.util.Stack;

public class LeetcodeAsteroid {
	static final boolean DEBUG = false;
	static Stack<Integer> stack = new Stack<>();

	public static int absCompare (int a, int b) {
		if (a < b) {
			return -1;
		} else if (a == b) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void main (String args[]) {
		int[] a = {3,-69,-65,67,-76,34,10,96,55,77,85,56,99,-1,6,-37,-7,-70,75,-60,4,-73,35,-32,3,-7,72,83,-82,70,68,63,33,-68,-100,61,-96,27,89,81,-11,-63,69,49,-34,23,87,23,26,-67,67,-100,-84,-89,-76,-42,-86,-96,86,7,25,9,-17,7,-15,-35,-65,-82,-32,90,-27,39,30,-42,-3,-71,-46,24,20,-84,8,51,-84,24,53,66,87,-64,27,-5,-68,86,-49,-53,68,21,-88,58,21,-18};

		for (int i = 0; i < a.length; i++) {
			if (stack.isEmpty()) {
				stack.push(a[i]);
			} else {
				processStack(a[i]);
			}
		}
		
		printStack();
		stack.removeAllElements();
		printStack();
	}

	private static void processStack(int asteroid) {
		// TODO Auto-generated method stub
		if (stack.empty()) {
			stack.push(asteroid);
			return;
		}
		int topOfStack = stack.pop();

		/*
		 * 1. If the sign of topOfStack and incoming element is the same, push to stack and continue
		 * 2. If the sign of topOfStack is -ve, push the incoming element and continue
		 * 
		 */

		if (topOfStack < 0 || (topOfStack > 0 && asteroid > 0)) {
			stack.push(topOfStack);
			stack.push(asteroid);
			return;
		}

		/*
		 * 3. If the sign of topOfStack is +ve and the incoming is -ve, recursively process the
		 * stack
		 */
		int compResult = absCompare(Math.abs(topOfStack), Math.abs(asteroid));
		if (compResult == 0) {
			/*
			 * They destroy each other.
			 */
			return;
		} else if (compResult == 1) {
			/*
			 * The incoming element is smaller. Push back topOfStack and continue;
			 */
			stack.push(topOfStack);
			return;
		} else {
			processStack(asteroid);
		}
	}

	private static void printStack() {
		// TODO Auto-generated method stub
		Iterator<Integer> iter = stack.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}