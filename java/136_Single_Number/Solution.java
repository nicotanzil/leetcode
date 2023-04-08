import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // intuitive approach by sorting the array
    // and finding unidentical neighbor
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        int seen = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (i % 2 == 1 && seen != list.get(i)) {
                return seen;
            } else {
                seen = list.get(i);
            }
        }
        return seen;
    }

    // less intuitive approach using XOR
    public int singleNumberXor(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}