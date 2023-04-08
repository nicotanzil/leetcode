import java.util.*;

public class Solution {

    // the approach is based on sorting the input array and
    // then using a 2-pointer approach to find three numbers
    // that sum up to zero. The algorithm avoids duplicates
    // by skipping over any numbers that are the same as the
    // the previous number.
    // low pointer -> starts from the left and moves right
    // high pointer -> starts from the right and moves left

    // O(n^2) time complexity
    // the time complexity of this approach is O(n^2) because
    // it involves sorting the array and then using two nested
    // loops to find the three numbers that sum up to zero.

    // O(1) space complexity
    // the space complexity of this approach is O(1) because
    // it does not use any extra space.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum3 = nums[i] + nums[lo] + nums[hi];
                    if (sum3 > 0) {
                        hi--; // too large, decrease high
                    } else if (sum3 < 0) {
                        lo++; // too small, increase low
                    } else {
                        res.add(Arrays.asList(nums[lo], nums[i], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                }
            }
        }

        return res;
    }
}
