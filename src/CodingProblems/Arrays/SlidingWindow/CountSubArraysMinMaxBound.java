package Arrays.SlidingWindow;

public class CountSubArraysMinMaxBound {
    //    We can use a sliding window approach to find all subarrays with minimum value minK and maximum value maxK. We can keep track of the start index of the current subarray and update it whenever we encounter a value that is less than minK or greater than maxK.
//    When we find a subarray with both minK and maxK, we can count the number of subarrays that can be formed by taking the minimum index of minK and maxK as the starting point and the current index as the ending point.
//
//            Approach
//    Initialize res to 0, start to 0, and minFound and maxFound to false.
//    Iterate over the array nums.
//    If the current value num is less than minK or greater than maxK, set minFound and maxFound to false and update start to i+1.
//    If num is equal to minK, set minFound to true and update minStart to i.
//    If num is equal to maxK, set maxFound to true and update maxStart to i.
//    If minFound and maxFound are both true, add (min(minStart, maxStart) - start + 1) to res.
//    Return res.
    public long countSubarrays(int[] nums, int minK, int maxK) {
        boolean minFound = false;
        boolean maxFound = false;
        long count = 0;
        int left = 0, minStart = 0, maxStart = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            if (num < minK || num > maxK) {
                minFound = false;
                maxFound = false;
                left = right + 1;
            }
            if (num == minK) {
                minFound = true;
                minStart = right;
            }
            if (num == maxK) {
                maxFound = true;
                maxStart = right;
            }
            if (minFound && maxFound) {
                count += (Math.min(minStart, maxStart) - left + 1);
            }
        }
        return count;
    }
}
