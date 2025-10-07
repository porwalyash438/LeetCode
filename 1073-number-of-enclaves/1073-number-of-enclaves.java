class Solution {
    public void dfs(int i,int j,boolean visited[][],int [][] grid){
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int []delrow = {-1,0,1,0};
        int []delcol = {0,1,0,-1};
        for(int k=0;k<4;k++){
                int nrow = i+delrow[k];
                int ncol = j+delcol[k];
                if(nrow >=0 && nrow <n && ncol >=0 && ncol <m && !visited[nrow][ncol] && grid[nrow][ncol] == 1 ){
                    dfs(nrow,ncol,visited,grid);
                }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited [][] = new boolean [n][m];
        for(int j=0;j<m;j++){
            if(!visited[0][j] && grid[0][j] == 1){
                dfs(0,j,visited,grid);
            }

            if(!visited[n-1][j] && grid[n-1][j] == 1){
                dfs(n-1,j,visited,grid);
            }
        }
         for(int i=0;i<n;i++){
            if(!visited[i][0] && grid[i][0] == 1){
                dfs(i,0,visited,grid);
            }

            if(!visited[i][m-1] && grid[i][m-1] == 1){
                dfs(i,m-1,visited,grid);
            }
        }

        int enclave = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    visited[i][j] = true;
                    enclave++;
                }
            }
        }
        return enclave;
    }
}