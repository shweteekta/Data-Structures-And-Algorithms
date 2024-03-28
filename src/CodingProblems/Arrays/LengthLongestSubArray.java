package Arrays;

import java.util.*;

public class LengthLongestSubArray {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0; int left = 0;
        for (int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right],0) + 1);
            if (map.get(nums[right]) > k){
                while (left <= right && map.get(nums[right]) > k){
                    map.put(nums[left],map.get(nums[left])-1);
                    left++;
                }
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
