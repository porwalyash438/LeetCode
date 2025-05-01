import java.util.*;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    ans[nrow][ncol] = ans[row][col] + 1;
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        return ans;
    }
}
