import java.util.HashMap;

public class Leetcode1771 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(-3);
		head.next.next.next.next = new ListNode(5);
		
		head = removeZeroSumSublists(head);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

	private static ListNode removeZeroSumSublists(ListNode head) {
		// TODO Auto-generated method stub
		if (head == null) {
            return head;
        }
        
        HashMap<Integer, ListNode> hm = new HashMap<>();
        ListNode curr = head;
        int sum = 0;
        
        while (curr != null) {
            sum += curr.val;
            
            if (sum == 0) {
                head = curr.next;
                return removeZeroSumSublists(head);
            }
            
            if (hm.containsKey(sum)) {
                ListNode node = hm.get(sum).next;
                int tmp = sum;
                while (node != curr) {
                    tmp += node.val;
                    hm.remove(tmp);
                    node = node.next;
                }
                hm.get(sum).next = curr.next;
                return removeZeroSumSublists(head);
            }
            
            hm.put(sum, curr);
            curr = curr.next;
        }
        
        return head;
	}
}
