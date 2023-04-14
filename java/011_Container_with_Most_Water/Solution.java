
public class Solution {

    // This is a two pointer problem.
    // The idea is to start from the two ends of the array and move the pointer
    // that points to the shorter line inwards.
    // This is because the area is determined by the shorter line and any move
    // of the longer line won't increase the area.
    // Only possible case is that the area will be the same as the current area.

    // Time: O(n)
    // Space: O(1)

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0;
        while (i < j) {
            water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }
}
