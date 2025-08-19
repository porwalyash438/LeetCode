class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount + 1;                
        int[][] dp = new int[n + 1][amount + 1];
        for (int j = 1; j <= amount; j++) dp[0][j] = INF;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int a = 1; a <= amount; a++) {
                int notTake = dp[i - 1][a];
                int take = (a >= coin) ? 1 + dp[i][a - coin] : INF;
                dp[i][a] = Math.min(notTake, take);
            }
        }

        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }
}
