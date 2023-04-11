public class Solution {
    int left = 0;
    int maxLength = 0;

    // this solution will find the substring by spreading from the center
    // of the string and then compare the length of the substring with the
    // current maximum length

    // Time: O(n^2)
    // Space: O(1)

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        maxLength = 0;
        for (int i = 0; i < len - 1; i++) {
            extendSubstring(s, i, i); // string with odd length
            extendSubstring(s, i, i + 1); // string with even length
        }

        return s.substring(left, maxLength + left);
    }

    public void extendSubstring(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }

        if (maxLength < hi - lo - 1) {
            maxLength = (hi - 1) - lo;
            left = lo + 1;
        }
    }
}
