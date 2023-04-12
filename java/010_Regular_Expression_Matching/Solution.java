
public class Solution {

    // This solution will use dynamic programming to solve the problem. The
    // solution will use a 2D boolean array called 'dp' to store every
    // combinations of the string and the pattern.

    /**
     * The first column of the dp array will be true if the pattern is empty
     * and false otherwise.
     * The first row of the dp array will be true if the pattern is '*' and
     * false otherwise.
     */

    /*
     * most detailed explanation I can find:
     * https://leetcode.com/problems/regular-expression-matching/solutions/191830/
     */

    // Time: O(m * n)
    // Space: O(m * n)

    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0)
            return (s == null || s.length() == 0);

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 2; i <= p.length(); i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
