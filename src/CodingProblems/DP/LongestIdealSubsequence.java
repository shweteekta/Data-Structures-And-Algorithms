package DP;

public class LongestIdealSubsequence {
//    t is a subsequence of the string s.
//    The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
//    Return the length of the longest ideal string.
//
//    A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
//
//    Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.

    public int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int n = s.length();

        for(int i = 0; i < n ;i++){
            char cc = s.charAt(i);
            int idx = cc - 'a';
            int max  = Integer.MIN_VALUE;

            int left = Math.max((idx-k), 0);
            int right = Math.min((idx + k), 26);

            for(int j = left; j <= right ; j++){
                max = Math.max(max, dp[j]);
            }

            dp[idx] = max+1;
        }

        int max = Integer.MIN_VALUE;

        for(int ele : dp){
            max = Math.max(ele, max);
        }

        return max;
    }
}
