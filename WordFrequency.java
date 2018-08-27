import java.util.*;

public class WordFrequency {
    @SuppressWarnings("unchecked")
	public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int res = e2.getValue() - e1.getValue();
                if (res == 0) {
                    res = e1.getKey().compareTo(e2.getKey());
                }
                
                return res;
            }
        });
        
        for (@SuppressWarnings("rawtypes") Map.Entry e : hm.entrySet()) {
        		//System.out.println("Adding " + e.getKey());
            pq.add(e);
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
        		list.add(pq.poll().getKey());
        }
       
        //Collections.reverse(list);
        return list;
    }
    
	public static void main(String[] args) {
		WordFrequency wq = new WordFrequency();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 1;
		
		List<String> list = wq.topKFrequent(words, k);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
