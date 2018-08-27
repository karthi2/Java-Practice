import java.util.*;

public class MultiplyStrings {
    public static void main (String args[]) {
        String a = "1246";
        String b = "159109";
        int count = 0;
        List<Double> result = new ArrayList<>();

        for (int i = a.length()-1; i >= 0; i--) {
            char c1 = a.charAt(i);
            int val1 = c1 - '0';

            List<Integer> list = new ArrayList<>();

            for (int k = 0; k < count; k++) {
                    list.add(0, 0);
            }

            int carry = 0;

            for (int j = b.length() - 1; j >= 0; j--) {
                char c2 = b.charAt(j);
                int val2 = c2 - '0';

                int prod = val1 * val2 + carry;
                carry = prod / 10;

                list.add(0, prod % 10);
            }
            count++;

            if (carry > 0) {
                list.add(0, carry);
                carry = 0;
            }

            double num = 0;
            for (int k = 0; k < list.size(); k++) {
                num = num * 10 + list.get(k);
            }
            //System.out.println(num);
            result.add(num);
        }

        double res = 0;
        for (int k = 0; k < result.size(); k++) {
            res = res + result.get(k);
        }

        System.out.printf("%.0f\n", res);
    }
}