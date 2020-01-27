import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode133 {
	private static class Node {
	    public int val;
	    public List<Node> neighbors;

	    @SuppressWarnings("unused")
		public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, null);
		List<Node> neighbors = new ArrayList<Node>();
		
		Node node1 = new Node(2, null);
		Node node2 = new Node(4, null);
		
		neighbors.add(node1);
		neighbors.add(node2);
		head.neighbors = neighbors;
		
		Node lastNode = new Node(3, null);
		neighbors = new ArrayList<Node>();
		neighbors.add(head);
		neighbors.add(lastNode);
		node1.neighbors = neighbors;
		
		neighbors = new ArrayList<Node>();
		neighbors.add(head);
		neighbors.add(lastNode);
		node2.neighbors = neighbors;
		
		neighbors = new ArrayList<Node>();
		neighbors.add(node1);
		neighbors.add(node2);
		lastNode.neighbors = neighbors;
		
		Node result = cloneGraph(head);
		System.out.println(result.val);
	}

	private static Node cloneGraph(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
            return node;
        }
        
        /* Add nodes to a queue and to a HashSet */
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        
        HashSet<Node> hs = new HashSet<>();
        
        for (int i = 0; i < q.size(); i++) {
            Node n = q.get(i);
            hs.add(node);
            Iterator<Node> iter = n.neighbors.iterator();
            while (iter.hasNext()) {
                Node p = iter.next();
                if (!q.contains(p)) {
                	q.add(p);
                }
                hs.add(p);
            }
        }
        
        /* Iterate through the HashSet and create new nodes */
        Iterator<Node> iter = hs.iterator();
        HashMap<Integer, Node> hm = new HashMap<>();
        Node result = null;
        List<Node> resultNeighbors = null;
        while (iter.hasNext()) {
            Node n = iter.next();
            Node p = null;
            if (!hm.containsKey(n.val)) {
                p = new Node(n.val, null);
                hm.put(p.val, p);
            } else {
                p = hm.get(n.val);
            }
            
            resultNeighbors = new ArrayList<>();
            
            Iterator<Node> neighborIter = n.neighbors.iterator();
            while (neighborIter.hasNext()) {
                Node neighbor = neighborIter.next();
                if (!hm.containsKey(neighbor.val)) {
                    Node newNeighbor = new Node(neighbor.val, null);
                    hm.put(newNeighbor.val, newNeighbor);
                    resultNeighbors.add(newNeighbor);
                } else {
                    resultNeighbors.add(hm.get(neighbor.val));
                }
            }
            p.neighbors = resultNeighbors;
            
            if (p.val == node.val && result == null) {
                result = p;
            }
        }
        
        return result;
	}
}
