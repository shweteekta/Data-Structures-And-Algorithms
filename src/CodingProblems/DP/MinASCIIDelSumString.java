package DP;

public class MinASCIIDelSumString {
//    Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
//    Example 1:
//    Input: s1 = "sea", s2 = "eat"
//    Output: 231
//    Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
//            Deleting "t" from "eat" adds 116 to the sum.
//    At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i <=m ;i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i=1; i <=n ;i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                int min = Math.min(c1 + dp[i-1][j], c2+dp[i][j-1]);
                dp[i][j] = (c1 == c2) ? dp[i-1][j-1] : min;
            }
        }
        return dp[m][n];
    }
}
