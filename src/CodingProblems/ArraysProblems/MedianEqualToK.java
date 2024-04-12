package ArraysProblems;

import java.util.*;

public class MedianEqualToK {
    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        long min = 0; int median = 0;
        Arrays.sort(nums); // Sort the array in ascending order
        int n = nums.length;
        int middleIndex = n / 2;
        median = nums[middleIndex];


        if(median == k) return 0;
        if(median > k){
            for (int i=middleIndex; i>=0; i--){
                if(nums[i] >=k){
                    min += (nums[i]-k);
                }
            }
        }

        if (median < k){
            for (int i=middleIndex; i<nums.length; i++){
                if(nums[i] <=k){
                    min += (k-nums[i]);
                }
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] nums = {69,89,57,31,84,97,50,38,91}; int k = 91;
        System.out.println(minOperationsToMakeMedianK( nums, k));
    }
}
