package Arrays.SlidingWindow;

public class MinOpReduceXToZero {
    //    You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
//
//    Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
//    Example 1:
//
//    Input: nums = [1,1,4,2,3], x = 5
//    Output: 2
//    Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
//    public int minOperations(int[] nums, int x) {
//        int targetSum = Arrays.stream(nums).sum() - x;
//        int n = nums.length;
//        int currentSum = 0;
//        int minLength = Integer.MAX_VALUE;
//        int left = 0;
//
//        for (int right = 0; right < n; right++) {
//            currentSum += nums[right];
//            while (currentSum > targetSum && left <= right) {
//                currentSum -= nums[left];
//                left++;
//            }
//            if (currentSum == targetSum) {
//                minLength = Math.min(minLength, n - (right - left + 1));
//            }
//        }
//        return minLength == Integer.MAX_VALUE ? -1 : minLength;
//    }
}
