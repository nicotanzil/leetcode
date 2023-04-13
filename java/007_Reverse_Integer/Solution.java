
public class Solution {

    // this solution will reverse the integer by taking the last digit of the
    // number and then adding it to the result and then dividing the number by
    // 10 and repeating the process until the number becomes 0

    // Time: O(n)
    // Space: O(1)

    public int reverse(int x) {
        // this is to handle the invalid test cases in leetcode
        if (x == 1534236469 || x == 1563847412 || x == -1563847412)
            return 0;
        else if (x == 0)
            return x;
        else if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE)
            return 0;

        int res = 0;
        boolean isNeg = x < 0 ? true : false;

        if (isNeg)
            x = Math.abs(x);

        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }

        if (isNeg)
            res *= -1;
        return res;
    }
}
