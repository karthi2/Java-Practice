import java.util.ArrayList;

public class LC234 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	ListNode node;
	
    public LC234(int i) {
		// TODO Auto-generated constructor stub
    		node = new ListNode(i);
    		node.next = new ListNode(i);
	}

	public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode node = head;
        ArrayList<Integer> list = new ArrayList<>();
        
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        
        int i = 0;
        int j = list.size() - 1;
        
        while (i < j) {
            System.out.println(list.get(i) + " " + list.get(j));
            int a = list.get(i);
            int b = list.get(j);
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC234 lc234 = new LC234(-129);
		
		ListNode node = lc234.getNode();
		System.out.println(lc234.isPalindrome(node));
		
	}

	private ListNode getNode() {
		// TODO Auto-generated method stub
		return this.node;
	}

}
