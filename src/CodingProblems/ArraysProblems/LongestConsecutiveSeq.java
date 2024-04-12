package ArraysProblems;

import java.util.*;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int length = 1;
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                length += left + right;
                max = Math.max(max, length);
                map.put(num, length);
                map.put(num - left, length);
                map.put(num + right, length);
            }
        }
        return max;
    }
}
