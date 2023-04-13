import java.util.HashMap;

public class Solution {

    // In this solution, we will use a hashmap to store the
    // values of all the roman numerals. Then we will iterate
    // through the string and check if the current character
    // is greater than the previous character. If it is, then
    // we will subtract the previous value from the current
    // value and add the difference to the result. If it is
    // not, then we will simply add the current value to the
    // result.

    // Time: O(n)
    // Space: O(1)

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s.length() <= 0)
            return 0;

        int result = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int prev = map.get(s.charAt(i - 1));
            int curr = map.get(s.charAt(i));
            if (prev < curr) {
                result = result - prev + (curr - prev);
            } else {
                result += curr;
            }
        }

        return result;
    }
}
