
public class ListAdjSwap {
	public static void main (String args[]) {	
		LinkList list = new LinkList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.adjSwap ();
		
		list.print();
	}
}
