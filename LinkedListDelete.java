import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDelete {
    public static void deleteNode (LinkedList<Integer> list, int nodeToDelete) {
        if (list.size() == 0) {
            return;
        }

        ArrayList<Integer> arList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        		if (list.get(i) == nodeToDelete) {
        			arList.add(i);
        		}
        }
        
        for (int i = 0; i < arList.size(); i++) {
        		list.removeAll(arList);
        }
    }
    
    public static void main (String args[]) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(5);
        list.add(6);
        list.add(11);
        list.add(13);
        list.add(3);
        list.add(3);

        int nodeToDelete = 3;

        deleteNode(list, nodeToDelete);
        
        for (int i = 0; i < list.size(); i++) {
        		System.out.println(list.get(i));
        }
    }
}
