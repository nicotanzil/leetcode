import java.util.HashMap;
import java.util.Map;

public class Solution {

    // This solution will first count the number of times each character
    // appears in the string. Then it will iterate through the map and
    // add the number of times each character appears to the sum. If the
    // number of times a character appears is odd, then we will add 1 to
    // the sum and set the isOdd flag to true. This is done because we
    // can only have one character that appears an odd number of times.
    // If the character appears an even number of times, then we can
    // add the number of times it appears to the sum. At the end, we
    // will return the sum.

    // Time: O(n)
    // Space: O(n)

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        boolean isOdd = false;
        int sum = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (!isOdd && e.getValue() % 2 == 1) {
                sum++;
                isOdd = true;
            }
            sum += (e.getValue() / 2) * 2;
        }

        return sum;
    }
}
