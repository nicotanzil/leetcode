import java.util.LinkedList;
import java.util.List;

public class Solution {

    // This solution is based on the BFS approach. We start with an
    // empty string in the queue. Then we iterate through the digits
    // and for each digit, we remove the string from the front of the
    // queue and append each letter that corresponds to the digit to
    // the string. We then add the new string to the back of the queue.
    // We keep doing this until we have processed all the digits in the
    // input string. The resulting strings in the queue are the letter
    // combinations that correspond to the input digits.

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty())
            return ans;

        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add("");

        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String s = ans.remove();
                for (char c : mapping[x].toCharArray()) {
                    ans.add(s + c);
                }
            }
        }
        return ans;
    }
}
