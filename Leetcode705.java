import java.util.ArrayList;

public class Leetcode705 {
	private ArrayList<Integer> hashKeyArray;

	/** Initialize your data structure here. */
	public Leetcode705() {
		hashKeyArray = new ArrayList<>();
	}

	public void add(int key) {
		if (hashKeyArray.contains(key)) {
			return;
		}

		int arrayListLen = hashKeyArray.size();
		if (arrayListLen == 0) {
			hashKeyArray.add(key);
		} else {
			int random = (int) (Math.random() * (arrayListLen));
			hashKeyArray.add(random, key);
		}
	}

	public void remove(int key) {
		hashKeyArray.remove(new Integer(key));
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return hashKeyArray.contains(key);
	}
	
	public static void main (String[] args) {
		Leetcode705 obj = new Leetcode705();
		obj.add(1);
		obj.add(2);
		System.out.println(obj.contains(1));
		System.out.println(obj.contains(3));
		obj.add(2);
		System.out.println(obj.contains(2));
		obj.remove(2);
		System.out.println(obj.contains(2));
	}
}
