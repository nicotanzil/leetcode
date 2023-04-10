import java.util.HashMap;

public class Solution {

    // use a hashmap to store the values and their indices
    // time complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[1];
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.getOrDefault(find, -1) != -1 && map.get(find) != i) {
                res = new int[] { i, map.get(find) };
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    // brute force solution
    // time complexity: O(n^2)
    public int[] twoSumBrute(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

}
