package DP;

import java.util.*;

public class LargestDivisibleSubset {
    //    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//    answer[i] % answer[j] == 0, or
//    answer[j] % answer[i] == 0
//    If there are multiple solutions, return any of them.
//    Input: nums = [1,2,3]
//    Output: [1,2]
//    Explanation: [1,3] is also accepted.
    // This problem is similar to LIS problem
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSubsetSize = 1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSubsetSize) {
                        maxSubsetSize = dp[i];
                        maxIndex = i;
                    }
                }

            }
        }

        int currentNum = nums[maxIndex];
        for (int i = maxIndex; i >= 0 ; i--) {
            if(currentNum % nums[i] == 0 && dp[i] == maxSubsetSize){
                result.add(currentNum);
                currentNum = nums[i];
                maxSubsetSize--;
            }
        }
        return result;
    }
    }
