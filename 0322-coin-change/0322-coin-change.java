class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int INF = amount + 1;           
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = INF;

        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] = Math.min(dp[a], dp[a - coin] + 1);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}
