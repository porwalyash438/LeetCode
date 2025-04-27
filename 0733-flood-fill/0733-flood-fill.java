class Solution {

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol,
            int initColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && image[nrow][ncol] == initColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, initColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            ans[i] = image[i].clone();
        }

        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };

        if (initColor != newColor) {
            dfs(sr, sc, ans, image, newColor, delRow, delCol, initColor);
        }

        return ans;
    }
}
