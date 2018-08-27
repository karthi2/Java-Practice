/*
 * Not complete yet
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeAccountMerge {
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, HashMap<String, List<String>>> hm = new HashMap<>();
		
		Iterator<List<String>> iter = accounts.iterator();
		
		while (iter.hasNext()) {
			List<String> account = iter.next();
			Iterator<String> accountIter = account.iterator();
			
			String name = accountIter.next();
			
			while (accountIter.hasNext()) {
				String email = accountIter.next();
				if (hm.containsKey(email)) {
					
				} else {
					HashMap<String, List<String>> accountHm = new HashMap<>();
					LinkedList<String> emails = new LinkedList<>();
					Iterator<String> emailList = account.listIterator(1);
					
					while (emailList.hasNext()) {
						emails.add(emailList.next());
					}
					
					accountHm.put(name, emails);
					
					hm.put(email, accountHm);
				}
			}
		}
		
		
		return null;
	}
	
	public static void main (String args[]) {
		
		/*
		 * Just a test
		 */
		LinkedList<Integer> linkList = new LinkedList<>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		linkList.add(6);
		
		Iterator<Integer> listIter1 = linkList.iterator();
		
		
		while (listIter1.hasNext()) {
			System.out.println("listIter1 " + listIter1.next());
			Iterator<Integer> listIter2 = linkList.iterator();
			while (listIter2.hasNext()) {
				System.out.print("listIter2 " + listIter2.next() + " ");
			}
			System.out.println();
		}
		
	}
}
