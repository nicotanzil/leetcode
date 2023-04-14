import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Brute Force approach
    // This solution implements a brute force approach to
    // problem by iterating through the whole array then
    // adding all the current sum with every element after
    // that index

    // Time : O(n^2)
    // Space : O(1)

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int out = 0;

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if (sum == k) {
                out++;
            }

            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    out++;
                }
            }
        }

        return out;
    }

    // Prefix Sum approach
    // This solution implements a prefix sum approach to
    // problem by iterating through the whole array then
    // adding all the current sum with every element after
    // that index

    // Time : O(n)
    // Space : O(n)

    public int subarraySumPresum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
