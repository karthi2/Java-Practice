import java.util.Stack;

public class Leetcode155 {
	int min;
	Stack<Integer> stack;

	public Leetcode155() {
		stack = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x <= min) {
			min = x;
		}
		stack.push(min);
		stack.push(x);
	}

	public void pop() {
		stack.pop();
		stack.pop();

		/* Find the next min */
		if (!stack.isEmpty()) {
			int pop = stack.peek();
			stack.pop();
			min = stack.peek();
			stack.push(pop);
		} else {
			min = Integer.MAX_VALUE;
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main (String[] args) {
		Leetcode155 obj = new Leetcode155();
		obj.push(2147483646);
		obj.push(2147483646);
		obj.push(2147483647);
		System.out.println(obj.top());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		obj.push(2147483647);
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.push(-2147483647);
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
	}
}
