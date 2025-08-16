class Solution {
    public int solve(int n, int memo[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(memo[n] != -1){
            return  memo[n];
        }
        int oneStep = solve(n-1,memo);
        int twoStep = solve(n-2,memo);

        return memo[n] = oneStep + twoStep;
    }
    public int climbStairs(int n) {
        int memo[] = new int[46];
        for(int i=0;i<46;i++){
            Arrays.fill(memo,-1);
        }
        return solve(n,memo);
    }
}