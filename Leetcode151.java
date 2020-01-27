public class Leetcode151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a good   example";
		
		String[] arr = s.trim().replaceAll(" +", " ").split(" ");
		StringBuilder sb = new StringBuilder();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals(" ")) {
				sb.append(arr[i]);
				sb.append(" ");
			}
		}
		
		String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                stringBuilder.append(words[i]);
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder.toString().trim());
        
		System.out.println(sb.toString());
	}

}
