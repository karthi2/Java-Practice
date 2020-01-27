import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class Leetcode297 {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	TreeNode root;
	
	Leetcode297 () {
		root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode297 obj = new Leetcode297();
		
		String serialized = obj.serialize();
		
		TreeNode newRoot = obj.deserialize(serialized);
		System.out.println(newRoot.val);
	}

	private TreeNode deserialize(String serialized) {
		// TODO Auto-generated method stub
		/* Child nodes are at 2n and 2n+1 */
		
		if (serialized == null) {
			return null;
		}
		
		TreeNode root = null;
		TreeNode node = null;
		HashMap<Integer, TreeNode> hm = new HashMap<>();
		String nodes[] = serialized.split(",");
		
		for (int i = 0; i < nodes.length; i++) {
			 if (!nodes[i].equals("null")) {
				 node = new TreeNode(Integer.parseInt(nodes[i]));
				 hm.put(i, node);
			 }
		}
		
		int count = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (root == null) {
				root = hm.get(i);
			}
			
			node = hm.get(i);
			if (node != null) {
				node.left = hm.get(2*(i-count) + 1);
				node.right = hm.get(2*(i-count) + 2);
			} else {
				count++;
			}
		}
		
		return root;
	}

	private String serialize() {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		
		while (!list.isEmpty()) {
			TreeNode node = list.remove(0);
			if (node == null) {
                sb.append(",null");
            } else {
            	if (sb.length() == 0) {
            		sb.append(new Integer(node.val).toString());
            	} else {
            		sb.append(","+new Integer(node.val).toString());
            	}
                list.add(node.left);
                list.add(node.right);
            }
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}

}
