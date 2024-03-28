package Arrays;

public class LongestSubArrayWithSumK {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int m = a.length;
        if (m == 1) return 1;
        long sum = 0;
        int maxLength = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr2 < m){
            sum = sum + a[ptr2];
            if (sum > k){
                while (sum > k && ptr1 <= ptr2){
                    sum = sum - a[ptr1];
                    ptr1++;
                }
            }
            if (sum == k){
                maxLength = Math.max(maxLength, ptr2 - ptr1 +1);
            }
            ptr2++;
        }

        return maxLength;
    }
}
