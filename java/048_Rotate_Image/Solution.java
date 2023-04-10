public class Solution {

    // reverse the matrix
    // then swap the elements in the matrix
    // for example:
    // 1 2 3     7 8 9     7 4 1
    // 4 5 6  -> 4 5 6  -> 8 5 2
    // 7 8 9     1 2 3     9 6 3

    // Time: O(n^2)
    // Space: O(1)

    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[rows - 1 - i];
            matrix[rows - 1 - i] = temp;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
