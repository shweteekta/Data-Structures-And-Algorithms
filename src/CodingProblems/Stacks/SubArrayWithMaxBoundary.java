package Stacks;

import java.util.ArrayDeque;

public class SubArrayWithMaxBoundary {
//    You are given an array of positive integers nums.
//    Return the number of
//    subarrays
//    of nums, where the first and the last elements of the subarray are equal to the largest element in the subarray.
//    Example 1:
//    Input: nums = [1,4,3,3,2]
//    Output: 6
//
//    There are 6 subarrays which have the first and the last elements equal to the largest element of the subarray:
//    subarray [1,4,3,3,2], with its largest element 1. The first element is 1 and the last element is also 1.
//    subarray [1,4,3,3,2], with its largest element 4. The first element is 4 and the last element is also 4.
//    subarray [1,4,3,3,2], with its largest element 3. The first element is 3 and the last element is also 3.
//    subarray [1,4,3,3,2], with its largest element 3. The first element is 3 and the last element is also 3.
//    subarray [1,4,3,3,2], with its largest element 2. The first element is 2 and the last element is also 2.
//    subarray [1,4,3,3,2], with its largest element 3. The first element is 3 and the last element is also 3.
//    Hence, we return 6.
    public static long numberOfSubarrays(int[] A) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        long res = 0;
        for (int a : A) {
            while (!stack.isEmpty() && stack.peek()[0] < a)
                stack.pop();
            if (stack.isEmpty() || stack.peek()[0] != a)
                stack.push(new int[]{a, 0});
            int[] top = stack.peek();
            top[1]++;
            res += top[1];
        }
        return res;
    }
}
