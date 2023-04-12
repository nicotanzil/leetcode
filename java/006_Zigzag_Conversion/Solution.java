import java.util.ArrayList;
import java.util.List;

public class Solution {

    // this solution will convert the string to a zigzag pattern by using a list
    // of string builders and then appending the characters to the string builders
    // and then finally appending the string builders to a string builder and
    // then returning the string builder as a string

    // Time: O(n)
    // Space: O(n)

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }
}
