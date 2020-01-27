
public class Leetcode437 {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	TreeNode node;
	
	Leetcode437 () {
		node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(-3);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(2);
		node.left.left.left = new TreeNode(3);
		node.left.left.right = new TreeNode(-2);
		node.left.right.right = new TreeNode(1);
		node.right.right = new TreeNode(11);
	}
	
	public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;
        return inorder(root, 0, sum, count);
    }
	
	private int inorder (TreeNode node, int val, int sum, int count) {
		if (node == null) {
            return count;
        }
        
        inorder(node.left, val, sum, count);
        val += node.val;
        if (val == sum) {
            count++;
        }
        System.out.print(val + " ");
        inorder(node.right, val, sum, count);
        return count;
	}
	
	public static void main (String[] args) {
		Leetcode437 obj = new Leetcode437();
		obj.pathSum(obj.node, 8);
	}
}
