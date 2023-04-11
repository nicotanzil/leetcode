public class Solution {

    // this solution will start from the top right corner and then
    // move left or down depending on the value of the current cell
    // Time: O(m + n)
    // Space: O(1)

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (target == matrix[row][col]) {
                return true;
            }
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
