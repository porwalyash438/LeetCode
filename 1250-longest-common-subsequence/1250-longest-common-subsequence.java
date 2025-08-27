class Solution {
    public int solve(String s1,String s2,int n,int m,int [][] memo){
        if(n == 0 || m == 0) return  0;
        if(memo[n-1][m-1] != -1) return memo[n-1][m-1];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return memo[n-1][m-1] = 1+solve(s1,s2,n-1,m-1,memo);
        }
        return memo[n-1][m-1] = Math.max(solve(s1,s2,n-1,m,memo),solve(s1,s2,n,m-1,memo));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][] memo = new int [n][m];
        for(int [] i : memo){
            Arrays.fill(i,-1);
        }
        return solve(text1,text2,n,m,memo);
    }
}