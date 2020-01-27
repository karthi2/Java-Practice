import java.util.ArrayList;
import java.util.List;

public class Leetcode230 {
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		int k = 1;
		List<Integer> list = new ArrayList<>();
		inorder(root, k, list);
		System.out.println(list.get(list.size()-1));
		
	}

	private static int inorder(TreeNode root, int k, List<Integer> list) {
		// TODO Auto-generated method stub
		if (root == null) {
			return k;
		}
		
		k = inorder(root.left, k, list);
		if (k == 0) {
			return k;
		}
		
		list.add(root.val);
		k--;
		if (k == 0) {
			return 0;
		}
		
		k = inorder(root.right, k, list);
		return k;
	}

}
