import java.util.ArrayList;
import java.util.List;

public class Solution {

    // this solution uses a mathematical equation to calculate
    // the list of numbers in a certain row in the pascal's triangle
    // the equation is:
    // C(n, k) = n! / (k! * (n - k)!)
    // where n is the row number, and k is the index of the number in the row
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        long temp = 1;
        for (int i = 1, up = rowIndex, down = 1; i <= rowIndex; i++, up--, down++) {
            temp = temp * up / down;
            res.add((int) temp);
        }
        return res;
    }
}
