
public class Solution {

    // This solution will first calculate the product of all the numbers
    // in the array while also counting the number of zeros. If there is
    // more than one zero, then the product of all the numbers except the
    // current number will be 0. If there is only one zero, then the product
    // of all the numbers except the current number will be the product of
    // all the numbers in the array. If there are no zeros, then the product
    // of all the numbers except the current number will be the product of
    // all the numbers in the array divided by the current number.

    // Time: O(n)
    // Space: O(1)

    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum *= nums[i];
            } else {
                zeroCount++;
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                if (nums[i] == 0 && zeroCount == 1) {
                    res[i] = sum;
                } else
                    res[i] = 0;
            } else {
                res[i] = sum / nums[i];
            }
        }

        return res;
    }
}
