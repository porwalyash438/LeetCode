class Pair {
    int row;
    int col;
    public Pair(int first, int second) {
        this.row = first;
        this.col = second;
    }
}

class Solution {
    public void bfs(int row, int col, int vis[][], char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; 
        
        while (!q.isEmpty()) {
            int ro = q.peek().row;
            int co = q.peek().col;
            q.remove();
            
            for (int[] dir : directions) { 
                int nrow = ro + dir[0];
                int ncol = co + dir[1];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
