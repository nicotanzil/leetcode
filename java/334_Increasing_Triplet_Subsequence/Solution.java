
public class Solution {

    // In this solution, we need to keep track of 2 numbers:
    // Loop through the array, for each index i, we need to keep track of:
    // 1. The smallest number from the start to index i
    // 2. The biggest number from the end to index i

    // Loop through the array again
    // If the nums[i] is not equal smallest [i] and biggest[i]
    // and smallest[i] < biggest[i] we found the subsequence

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] smallest = new int[n];
        int[] biggest = new int[n];

        smallest[0] = nums[0];
        biggest[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (nums[i] < smallest[i - 1]) {
                smallest[i] = nums[i];
            } else {
                smallest[i] = smallest[i - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > biggest[i + 1]) {
                biggest[i] = nums[i];
            } else {
                biggest[i] = biggest[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != smallest[i] && nums[i] != biggest[i] && smallest[i] < biggest[i]) {
                // System.out.printf("[%d,%d,%d]\n", smallest[i], nums[i], biggest[i]);
                return true;
            }
        }

        return false;
    }
}
