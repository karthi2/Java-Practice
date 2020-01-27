import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode451 {
	private static class CharFreq {
        char c;
        int freq;
        
        CharFreq (char _c, int _freq) {
            c = _c;
            freq = _freq;
        }
    }
    
    static class CharComparator implements Comparator<CharFreq> {
        public int compare (CharFreq o1, CharFreq o2) {
            return o2.freq - o1.freq;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asdhfasdhfewqczschyuug";
		
		HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        }
        
        Comparator<CharFreq> freqComparator = new CharComparator();
        PriorityQueue<CharFreq> pq = new PriorityQueue<>(freqComparator);
        
        for (Character key : hm.keySet()) {
            CharFreq cf = new CharFreq(key, hm.get(key));
            pq.offer(cf);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            CharFreq cf = pq.poll();
            for (int i = 0; i < cf.freq; i++) {
                sb.append(cf.c);
            }
        }
        
        System.out.println(sb.toString());
	}

}
