import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Leetcode501 {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	TreeNode node;
	
	Leetcode501 () {
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
	
	public int[] findMode (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        traverse(root, hm);
        ArrayList<Integer> al = new ArrayList<>();
        
        Iterator<Entry<Integer, Integer>> iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Entry<Integer, Integer>)iter.next();
            al.add(pair.getValue());
        }
        
        Collections.sort(al, Collections.reverseOrder());
        List<Integer> result = new ArrayList<Integer>();
        result.add(al.get(0));
        for (int i = 1; i < al.size(); i++) {
        	if (al.get(i) == al.get(i-1)) {
        		result.add(al.get(i));
        	} else {
        		break;
        	}
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private static void traverse(TreeNode root, HashMap<Integer, Integer> hm) {
    	if (root == null) {
    		return;
    	}
    	
        traverse(root.left, hm);
        if (!hm.containsKey(root.val)) {
            hm.put(root.val, 1);
        } else {
            hm.put(root.val, hm.get(root.val)+1);
        }
        traverse(root.right, hm);
        
        return;
    }
    
    public static void main (String[] args) {
    	Leetcode501 obj = new Leetcode501();
    	
    	int[] result = obj.findMode(obj.node);
    	for (int i = 0; i < result.length; i++) {
    		System.out.println(result[i]);
    	}
    }
}
