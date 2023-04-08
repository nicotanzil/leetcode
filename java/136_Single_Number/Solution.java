import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // intuitive approach by sorting the array
    // and finding unidentical neighbor
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int seen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && seen != nums[i]) {
                return seen;
            } else {
                seen = nums[i];
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