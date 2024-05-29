package ArraysProblems.SlidingWindow;

public class SubArrayWithBoundaryMax {
//    Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
//    The test cases are generated so that the answer will fit in a 32-bit integer.
//    Example 1:
//    Input: nums = [2,1,4,3], left = 2, right = 3
//    Output: 3
//    Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int total = 0;
        int count = 0;
        int leftIndex = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] >= left && nums[i] <= right){
                count = i - leftIndex + 1;
                total += count;
            }
            else if(nums[i] < left){
                total += count;
            }
            else {
                leftIndex = i + 1;
                count=0;
            }
        }
        return total;
    }

}
