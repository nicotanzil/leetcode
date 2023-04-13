
public class Solution {

    // this solution will first reverse the given number and then
    // compare it with the original number. if they are equal, then
    // the given number is a palindrome

    // Time: O(n)
    // Space: O(1)

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int t = x;
        int sum = 0;
        while (t != 0) {
            sum = (sum * 10) + (t % 10);
            t /= 10;
        }

        return sum == x ? true : false;
    }
}
