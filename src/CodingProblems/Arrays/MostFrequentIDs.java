package Arrays;

import java.util.*;

public class MostFrequentIDs {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Integer, Long> map = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));
        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long count = 0;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            count += freq[i];
            map.put(nums[i], count);
            pq.add(new long[]{nums[i], count});
            while (true) {
                long[] curr = pq.peek();
                if (map.get((int)curr[0]) == curr[1]) {
                    ans[i] = curr[1];
                    break;
                }
                pq.remove();
            }
        }
        return ans;
    }
}
