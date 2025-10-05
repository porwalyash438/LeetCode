class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void bfs(int [][] image,int [][] ans,int sr,int sc,int color,boolean [][] visited){ 
        ans[sr][sc] = color;
        visited[sr][sc] = true;
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(sr,sc));
        int n = image.length;
        int m = image[0].length;
        while(!q.isEmpty()){
            pair p = q.poll();
            int ro = p.first;
            int co = p.second;

            for(int delrow = -1;delrow <=1;delrow++){
                for(int colrow=-1;colrow<=1;colrow++){
                    if(Math.abs(delrow) == Math.abs(colrow)) continue;
                    int nrow = ro + delrow;
                    int ncol = co + colrow;

                    if(nrow >=0 && nrow < n && ncol >=0 && ncol <m && ans[nrow][ncol] != color && image[nrow][ncol] == image[ro][co] && !visited[nrow][ncol]){
                        ans[nrow][ncol] = color;
                        visited[nrow][ncol] = true;

                        q.add(new pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int currcol = image[sr][sc];
        int ans[][] = new int [n][m];
        boolean visited [][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            ans[i] = image[i].clone();
        }
        if(currcol != color){
            bfs(image,ans,sr,sc,color,visited);
        }
        return ans;
    }
}