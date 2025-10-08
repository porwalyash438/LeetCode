class Solution {
    public boolean dfs(int node,int col,int color[],ArrayList<ArrayList<Integer>> adj){
        color[node] = col;
        for(int i:adj.get(node)){
            if(color[i] == -1){
                if(dfs(i,1-col,color,adj) == false) return false;
            }
            else if(color[i] ==  col) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int color [] = new int[n];
        for(int i=0;i<n;i++){
            color[i] = -1;
        }
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(dfs(i,0,color,adj)==false) return false;
            }
        }
        return true;
    }
}