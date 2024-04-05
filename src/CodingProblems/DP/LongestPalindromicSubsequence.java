package DP;

public class LongestPalindromicSubsequence {
//    Given a string s, find the longest palindromic subsequence's length in s.
//    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
//    Input: s = "bbbab"
//    Output: 4
//    Explanation: One possible longest palindromic subsequence is "bbbb".
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}
