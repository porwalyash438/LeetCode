class Solution {
    public void dfs(int i, int j, boolean[][] visited, char[][] mat) {
        visited[i][j] = true;
        int n = mat.length;
        int m = mat[0].length;
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && !visited[nrow][ncol] && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visited, mat);
            }
        }
    }

    public  void solve(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (!visited[0][j] && mat[0][j] == 'O') dfs(0, j, visited, mat);
            if (!visited[n - 1][j] && mat[n - 1][j] == 'O') dfs(n - 1, j, visited, mat);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && mat[i][0] == 'O') dfs(i, 0, visited, mat);
            if (!visited[i][m - 1] && mat[i][m - 1] == 'O') dfs(i, m - 1, visited, mat);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && mat[i][j] == 'O') mat[i][j] = 'X';
            }
        }
    }
}
   