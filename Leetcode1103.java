
public class Leetcode1103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candies = 15;
		int num_people = 4;
		int[] result = new int[num_people];
        int i = 0;
        int counter = 1;
        while (candies > 0) {
            result[i] += counter > candies ? candies : counter;
            candies -= counter;
            counter++;
            i = ((i+1) == num_people) ? 0 : ++i;
        }
        
        for (i = 0; i < num_people; i++) {
        	System.out.print(result[i] + " ");
        }
	}

}
