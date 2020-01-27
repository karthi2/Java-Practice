import java.util.ArrayList;
import java.util.List;

/* Logic is same as Leetcode2 */

public class Leetcode445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> list1 = new ArrayList<>();
		ArrayList <Integer> list2 = new ArrayList<>();
		list1.add(7);
		list1.add(2);
		list1.add(4);
		list1.add(3);
		
		list2.add(5);
		list2.add(6);
		list2.add(4);
		
		List<Integer> rList = new ArrayList<>();
		int sum = 0;
		int carry = 0;
		int i = list1.size() - 1;
		int j = list2.size() - 1;
		
		for (; i >= 0 && j >= 0; i--, j--) {
            sum = (carry + list1.get(i) + list2.get(j)) % 10;
            rList.add(0, sum);
            carry = (carry + list1.get(i) + list2.get(j)) / 10;
        }
		
		while (i >= 0) {
			sum = (carry + list1.get(i)) % 10;
			rList.add(0, sum);
			carry = (carry + list1.get(i)) / 10;
			i--;
		}
		
		while (j >= 0) {
			sum = (carry + list2.get(j)) % 10;
			rList.add(0, sum);
			carry = (carry + list2.get(j)) / 10;
			j--;
		}
		
		if (carry >= 0) {
			rList.add(0, carry);
		}
		
		System.out.println(rList);
	}

}
