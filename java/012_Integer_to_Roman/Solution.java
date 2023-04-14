
public class Solution {

    // This is a simple problem.
    // The idea is to use a greedy approach.
    // We start from the largest possible roman numeral and keep subtracting it
    // from the number until the number becomes 0.
    // We keep doing this until the number becomes 0.

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                sb.append(romans[i]);
                num -= nums[i];
            }
        }

        return sb.toString();
    }
}
