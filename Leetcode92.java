
public class Leetcode92 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		int m = 2;
		int n = 4;
		
		ListNode prev = head;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        if (m == 1) {
            head = reverseList(curr, n-m+1);
        } else {
            prev.next = reverseList(curr, n-m+1);
        }
        
        ListNode node = head;
        while (node != null) {
        	System.out.print(node.val + ", ");
        	node = node.next;
        }
	}

	private static ListNode reverseList(ListNode head, int count) {
		// TODO Auto-generated method stub
		ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while (count != 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = curr.next;
            }
            count--;
        }
        head.next = curr;   
        return prev;
	}

}
