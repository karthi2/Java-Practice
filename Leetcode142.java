
public class Leetcode142 {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next.next.next;
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2 != null) {
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                p2 = p2.next;
                continue;
            }
            
            if (p1 == p2) {
                break;
            }
        }
        
        if (p2 == null) {
        	System.out.println("No cycle detected");
            return;
        }
        
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        System.out.println(p1.val);
	}

}
