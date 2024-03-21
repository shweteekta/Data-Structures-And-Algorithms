package DP;

import java.util.Arrays;

public class CoinChangeProblem {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                if (dp[j - c] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
