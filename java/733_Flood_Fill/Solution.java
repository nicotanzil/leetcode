public class Solution {

    // This is a DFS problem
    // Time: O(n)
    // Space: O(n)

    private void dfs(int[][] image, int i, int j, int val, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor
                || image[i][j] != val) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i - 1, j, val, newColor);
        dfs(image, i + 1, j, val, newColor);
        dfs(image, i, j - 1, val, newColor);
        dfs(image, i, j + 1, val, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        dfs(image, sr, sc, val, color);
        return image;
    }
}