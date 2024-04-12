package ArraysProblems.SlidingWindow;

import java.util.*;

public class SubArraysKDiffIntegers {
//    Given an integer array nums and an integer k, return the number of good subarrays of nums.
//    A good array is an array where the number of different integers in that array is exactly k.
//    For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//    A subarray is a contiguous part of an array.
   // The calculation right - left + 1, counts the subarrays with at most k distinct integers.
//   After calculating the total count of subarrays with distinct integers less than or equal to k using slidingWindowAtMost(nums, k), we need to isolate the subarrays that strictly meet the target k.
//    This can be achieved by subtracting the total count of subarrays with distinct integers less than k (slidingWindowAtMost(nums, k - 1)) from the total count obtained earlier. By subtracting the latter from the former, we essentially remove the subarrays that don't reach k and are left with only the subarrays that have exactly k distinct integers.
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int totalCount = 0;
            int left1 = 0, left2 = 0;
            Map<Integer, Integer> countMap1 = new HashMap<>();
            Map<Integer, Integer> countMap2 = new HashMap<>();

            for (int right = 0; right < nums.length; right++) {
                countMap1.put(nums[right], countMap1.getOrDefault(nums[right], 0) + 1);
                countMap2.put(nums[right], countMap2.getOrDefault(nums[right], 0) + 1);

                while (countMap1.size() > k) {
                    countMap1.put(nums[left1], countMap1.get(nums[left1]) - 1);
                    if (countMap1.get(nums[left1]) == 0) {
                        countMap1.remove(nums[left1]);
                    }
                    left1++;
                }
                while (countMap2.size() > k - 1) {
                    countMap2.put(nums[left2], countMap2.get(nums[left2]) - 1);
                    if (countMap2.get(nums[left2]) == 0) {
                        countMap2.remove(nums[left2]);
                    }
                    left2++;
                }
                totalCount += left2 - left1;
            }
            return totalCount;
        }
    }
}
