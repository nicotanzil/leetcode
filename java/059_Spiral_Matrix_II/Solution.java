public class Solution {

    // This algorithm will mark the start and end index of the row and column
    // and then fill the matrix in a spiral order
    // Time: O(n^2)
    // Space: O(n^2)

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        int c = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // left to right
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = c++;
            }
            rowStart++;

            // up to bot
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = c++;
            }
            colEnd--;

            // right to left
            for (int i = colEnd; i >= colStart; i--) {
                if (rowStart <= rowEnd) {
                    res[rowEnd][i] = c++;
                }
            }
            rowEnd--;

            // bot to up
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    res[i][colStart] = c++;
                }
            }
            colStart++;
        }

        return res;

    }
}