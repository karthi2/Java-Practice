
public class Leetcode138 {
	private static class Node {
		public int val;
		public Node next;
		public Node random;
		
		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(-1, null, null);
		head.next = new Node(8, null, null);
		head.next.next = new Node(7, null, null);
		head.next.next.next = new Node(-3, null, null);
		head.next.next.next.next = new Node(4, null, null);

		head.random = head.next.next.next.next;
		head.next.random = head.next.next.next;
		head.next.next.next.next.random = head;

		Node curr = head;

		while (curr != null) {
			Node node = new Node(curr.val, curr.next, null);
			curr.next = node;
			curr = curr.next.next;
		}

		Node copyhead = head.next;
		Node copycurr = copyhead;
		curr = head;

		while (curr != null) {
			System.out.println(curr.val + ":" + copycurr.val);
			if (curr.random != null) {
				copycurr.random = curr.random.next;
			}
			
			curr = curr.next.next;
			if (copycurr.next != null) {
				copycurr = copycurr.next.next;
			}
		}
		
		curr = head;
		copycurr = copyhead;

		while (curr != null) {
			curr.next = copycurr.next;
			curr = curr.next;
			if (curr != null) {
				copycurr.next = curr.next;
			}
			copycurr = copycurr.next;
		}
		
		copycurr = copyhead;
		while (copycurr != null) {
			System.out.print(copycurr.val + ", ");
			copycurr = copycurr.next;
		}
		System.out.println();
	}
}
