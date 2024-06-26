package ArraysProblems.SlidingWindow;

import java.util.*;

public class SubArraySumDivisibleK {
//    Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//    A subarray is a contiguous part of an array.
//            Example 1:
//    Input: nums = [4,5,0,-2,-3,1], k = 5
//    Output: 7
//    Explanation: There are 7 subarrays with a sum divisible by k = 5:
//            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//    Example 2:
//
//    Input: nums = [5], k = 9
//    Output: 0
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        map.put(0, 1);
        for (int num: nums){
            prefixSum += num;
            int mod = prefixSum % k ;
            if (mod < 0) {
                mod += k;
            }
            maxLength += map.getOrDefault(mod,0);
            map.put(mod, map.getOrDefault(mod,0) + 1);
        }
        return maxLength;
    }
}
