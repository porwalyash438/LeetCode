class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && !visited[r][c]) {
                    if (isClosed(r, c, grid, visited, dirs)) {
                        result += 1;
                    }
                }
            }
        }
        return result;

    }
    private boolean isClosed(int row, int col, int[][] grid, boolean[][] visited, int[][] dirs) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        boolean isClosed = true;
        int rows = grid.length;
        int cols = grid[0].length;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0]; int c = node[1];
            for (int[] dir : dirs) {
                int neiR = r + dir[0]; int neiC = c + dir[1];
                if (neiR >= rows || neiC >= cols 
                || neiR < 0 || neiC < 0) {
                isClosed = false;
                } else if (grid[neiR][neiC] == 0 && !visited[neiR][neiC]) {
                    q.offer(new int[]{neiR, neiC});
                    visited[neiR][neiC] = true;
                }
            }
        }
        return isClosed;
    }
}