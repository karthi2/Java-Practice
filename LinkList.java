
public class LinkList {
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
			next = null;
		}
	}

	ListNode head;
	ListNode tail;

	public void add (int val) {
		if (head == null) {
			assert(tail == null);
			head = new ListNode(val);
			tail = head;
		} else {
			tail.next = new ListNode(val);
			tail = tail.next;
		}

	}

	public void remove (int val) {

	}

	public void remove (LinkList node) {

	}

	public void adjSwap() {
		// TODO Auto-generated method stub
		if (head == null) {
			return;
		}

		ListNode node1 = head;
		ListNode node2 = head.next;
		ListNode prev = null;

		while (node2 != null) {
			if (head == node1) {
				head = node2;
			}
			
			node1.next = node2.next;
			node2.next = node1;

			if (prev != null) {
				prev.next = node2;
			}
			
			//System.out.println(node2.val + " " + node1.val);

			prev = node1;
			node1 = node1.next;
			if (node1 != null) {
				node2 = node1.next;
			} else {
				node2 = null;
			}
		}
	}

	public void print() {
		// TODO Auto-generated method stub
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}
}
