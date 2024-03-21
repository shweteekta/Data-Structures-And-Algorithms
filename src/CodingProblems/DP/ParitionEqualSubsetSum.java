package DP;

import java.util.Arrays;

public class ParitionEqualSubsetSum {

    int dp[][];
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0)
            return false;
        totalSum /= 2;
        dp = new int[nums.length + 1][totalSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return canPartition(nums, 0, totalSum);
    }

    private boolean canPartition(int[] nums, int index, int totalSum) {
        if (totalSum <= 0 || index >= nums.length)
            return 0 == totalSum;
        if (dp[index][totalSum] != -1) {
            return dp[index][totalSum] != 0;
        }
        dp[index][totalSum] = canPartition(nums, index + 1, totalSum - nums[index]) ||
                canPartition(nums, index + 1, totalSum) ? 1 : 0;
        return dp[index][totalSum] != 0;
    }
}
