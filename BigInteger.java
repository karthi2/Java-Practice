
public class BigInteger {

	public String add (String num1, String num2) {
		StringBuilder result = new StringBuilder();
		long i = num1.length() - 1;
		long j = num2.length() - 1;
		int carry = 0;
		int a = 0;
		int b = 0;
		int c = 0;

		while (i >= 0 && j >= 0) {
			a = num1.charAt((int) i) - '0';
			b = num2.charAt((int) j) - '0';

			c = a + b + carry;
			carry = 0;
			if (c > 9) {
				carry = 1;
				c = c % 10;
			}

			result.insert(0, c);

			i--;
			j--;
		}

		while (i >= 0 || j >= 0) {
			if (i == -1) {
				b = num2.charAt((int) j) - '0';
				c = b + carry;
				j--;
			} else {
				a = num1.charAt((int) i) - '0';
				c = b + carry;
				i--;
			}

			carry = 0;
			if (c > 9) {
				carry = 1;
				c = c / 10;
			}
			result.insert(0, c);
		}
		
		if (carry == 1) {
			result.insert(0, carry);
		}

		return result.toString();
	}

	public String subtract (String num1, String num2) {
		return null;
	}

	public String multiply (String num1, String num2) {
		return null;
	}

	public String divide (String num1, String num2) {
		return null;
	}
}
