package DP;

public class TargetSum {
//    Input: nums = [1,1,1,1,1], target = 3
//    Output: 5
//    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//            -1 + 1 + 1 + 1 + 1 = 3
//            +1 - 1 + 1 + 1 + 1 = 3
//            +1 + 1 - 1 + 1 + 1 = 3
//            +1 + 1 + 1 - 1 + 1 = 3
//            +1 + 1 + 1 + 1 - 1 = 3
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Check if it's possible to achieve the target
        if (Math.abs(target) > sum) {
            return 0;
        }

        int[][] dp = new int[n + 1][2 * sum + 1];
        // Base case: if target is 0, there's 1 way to achieve it with an empty subset
        dp[0][sum] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[n][target + sum];
    }
}
