package DP;

public class LongestCommonSubsequence {
    // Create a 2D array -> if character is same then add 1 to previous left and prev row value i.e. previous character value else take the max between left and up
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (text1.equals(text2)) return m;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    int value = (i != 0) ? dp[i - 1][j] : (j != 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = (text1.charAt(i) == text2.charAt(j)) ? 1 : value;
                } else {
                    dp[i][j] = (text1.charAt(i) == text2.charAt(j)) ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
