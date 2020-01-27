import java.util.ArrayList;

public class Leetcode143 {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode head = null;
		ListNode node = new ListNode(1);
		head = node;
		
		node = new ListNode(2);
		head.next = node;
		node = new ListNode(3);
		head.next.next = node;
		node = new ListNode(4);
		head.next.next.next = node;
		//node = new ListNode(5);
		//head.next.next.next.next = node;
		
		ArrayList<ListNode> list = new ArrayList<>();
		node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		
		for (int i = 0; i < list.size() - 1; i += 2) {
			list.add(i+1, list.get(list.size() - 1));
			list.remove(list.size() - 1);
		}
		
		
		ListNode result = null;
        ListNode tail = null;
        
        for (int i = 0; i < list.size(); i++) {
            node = list.get(i);
            if (result == null) {
                result = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        tail.next = null;
        
        head = result;
        node = head;
        
        while (node != null) {
        	System.out.print(node.val + " ");
        	node = node.next;
        }
		
		head = reverse(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}

	private static ListNode reverse(ListNode head) {
		ListNode p0 = null;
		ListNode p1 = head;
		ListNode p2 = head.next;
		
		while (p1 != null) {
			p1.next = p0;
			p0 = p1;
			p1 = p2;
			if (p2 != null) {
				p2 = p2.next;
			}
		}
		
		return p0;
	}

}
