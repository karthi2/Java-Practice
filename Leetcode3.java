public class Leetcode3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccacbb";
		int maxLength = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = sb.indexOf(Character.toString(c));
			
			if (index != -1) {
				if (sb.length() > maxLength) {
					maxLength = sb.length();
				}
				
				sb.delete(0, index+1);
			}
			sb.append(c);
		}
		
		if (sb.length() > maxLength) {
			maxLength = sb.length();
		}
		
		System.out.println(maxLength);
	}

}
