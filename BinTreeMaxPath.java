
public class BinTreeMaxPath {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {val = x;}
	}
	
	TreeNode root;
	
	public void createTree () {
		TreeNode node = new TreeNode(-2);
		root = node;
		root.left = new TreeNode(-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTreeMaxPath bmp = new BinTreeMaxPath();
		bmp.createTree();
		
		System.out.println(bmp.maxPathSum(bmp.root));
	}

	private int preOrder (TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        int leftMax = Integer.MIN_VALUE;
        if (root.left != null) {
            leftMax = preOrder(root.left);
        }
        
        int rightMax = Integer.MIN_VALUE;
        if (root.right != null) {
            rightMax = preOrder(root.right);
        }
        
        //choose between 5 diff possibilities
        int res = Math.max(leftMax, rightMax);
        res = Math.max(res, root.val + res);
        
        if (root.left != null && root.right != null) {
        		res = Math.max(res, root.val + leftMax + rightMax);
        }
        
        return res;
	}
	
	private int maxPathSum(TreeNode root) {
		// TODO Auto-generated method stub
		return preOrder(root);
	}

}
