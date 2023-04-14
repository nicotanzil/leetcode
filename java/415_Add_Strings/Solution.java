public class Solution {

    // This solution will add the two numbers from the end and then
    // add the carry to the next digit. The carry is calculated by
    // dividing the sum by 10 and the digit is calculated by taking
    // the sum modulo 10.

    // Time: O(n)
    // Space: O(1)

    public String addStrings(String num1, String num2) {
        int rem = 0;
        String res = "";
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = 0;
            if (i >= 0)
                sum += Integer.parseInt(String.valueOf(num1.charAt(i)));
            if (j >= 0)
                sum += Integer.parseInt(String.valueOf(num2.charAt(j)));

            sum += rem;
            rem = sum / 10;
            sum = sum % 10;
            res = sum + res;
        }

        if (rem != 0) {
            res = rem + res;
        }

        return res;
    }
}
