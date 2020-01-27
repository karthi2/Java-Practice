
public class Leetcode725 {
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
		int k = 2;
		
		ListNode[] result = splitListToParts(head, k);
		for (int i = 0; i < result.length; i++) {
			ListNode curr = result[i];
			while (curr != null) {
				System.out.print(curr.val + ", ");
				curr = curr.next;
			}
			System.out.println();
		}
	}

	private static ListNode[] splitListToParts(ListNode root, int k) {
		// TODO Auto-generated method stub
		ListNode[] result = new ListNode[k];
        int len = 0;
        
        if (root == null) {
            return result;
        }
        
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int subLen = len/k;
        int rem = len % k;
        
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            ListNode prev = null;
            len = subLen + ((rem > 0) ? 1:0);
            rem--;
            while (len > 0) {
                prev = curr;
                curr = curr.next;
                len--;
            }
            if (prev != null) {
                prev.next = null;
            }
            result[i] = head;
        }
        
        return result;
	}
}
