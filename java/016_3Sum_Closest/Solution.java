import java.util.Arrays;

public class Solution {

    // This is a variation of the 3Sum problem. The approach is
    // similar to the 3Sum problem, except that we need to keep
    // track of the closest sum to the target. We can do this by
    // keeping track of the minimum difference between the sum
    // and the target. We can also use the same 2-pointer approach
    // to find the sum that is closest to the target.

    // O(n^2) time complexity
    // the time complexity of this approach is O(n^2) because
    // it involves sorting the array and then using two nested
    // loops to find the three numbers that sum up to zero.

    // O(1) space complexity
    // the space complexity of this approach is O(1) because
    // it does not use any extra space.

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum3 = nums[lo] + nums[i] + nums[hi];
                    if (Math.abs(min - target) > Math.abs(sum3 - target)) {
                        min = sum3;
                    }
                    if (sum3 > target)
                        hi--;
                    else if (sum3 < target)
                        lo++;
                    else {
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

        return min;
    }
}
