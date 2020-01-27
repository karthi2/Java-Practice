import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Leetcode609 {

	public static void main(String[] args) {
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efsfgh)\",\"root/c 3.txt(abdfcd)\",\"root/c/d 4.txt(efggdfh)"};

		HashSet<String> pathSet = new HashSet<String>();
		HashSet<String> contentSet = new HashSet<String>();
		
		HashMap<String, List<String>> hm = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		
		for (int i = 0; i < paths.length; i++) {
			String[] arr = paths[i].split(" ");
			
			for (int j = 1; j < arr.length; j++) {
				String s = new StringBuilder(arr[0]+"/"+arr[j]).toString();
				pathSet.add(s);
				
				int index = arr[j].indexOf("(");
				String content = arr[j].substring(index);
				contentSet.add(content);
				
				List<String> path = hm.getOrDefault(arr[j].substring(index), new ArrayList<String>());
				path.add(s.substring(0, s.lastIndexOf("(")));
				hm.put(content, path);
			}
		}
		
		Iterator<String> contentIter = contentSet.iterator();
		
		while (contentIter.hasNext()) {
			String content = contentIter.next();
			List<String> interList = new ArrayList<String>();
			Iterator<String> pathIter = pathSet.iterator();
			while (pathIter.hasNext()) {
				String path = pathIter.next();
				if (path.contains(content)) {
					interList.add(path.substring(0, path.lastIndexOf("(")));
				}
			}
			
			for (int i = 0; i < interList.size(); i++) {
				System.out.print(interList.get(i) + " ");
			}
			System.out.println();
			result.add(interList);
		}
		
		result.clear();
		Collection<List<String>> values = hm.values();
		for (List<String> value : values) {			
			if (value.size() > 1) {
				result.add(value);
			}
		}
	}
}
