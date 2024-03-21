package Recursion;

import java.util.Random;

public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        // k = (nums.length % 2 == 0) ? nums.length - k : nums.length - k + 1;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start <= end) {
            int pivotIndex = partition(nums, start, end, k);
            if (k == pivotIndex) {
                return nums[pivotIndex];
            } else if (k > pivotIndex) {
                return quickSelect(nums, pivotIndex + 1, end, k);
            } else {
                return quickSelect(nums, start, pivotIndex - 1, k);
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end, int k) {
        Random random = new Random();
        int pivot = random.nextInt(end - start + 1) + start;
        swap(nums, pivot, end);
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, end);
        return index;
    }

    private void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}
