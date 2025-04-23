class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = grid;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int countFreshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                }
                if (visited[i][j] == 1) {
                    countFreshOrange++;
                }
            }
        }

        if (countFreshOrange == 0)
            return 0;
        if (q.isEmpty())
            return -1;

        int minutes = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> cell = q.poll();
                int nrow = cell.getKey();
                int ncol = cell.getValue();

                for (int[] dir : directions) {
                    int i = nrow + dir[0];
                    int j = ncol + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new Pair<>(i, j));
                    }
                }
            }
            minutes++;
        }

        return countFreshOrange == 0 ? minutes : -1;
    }
}
