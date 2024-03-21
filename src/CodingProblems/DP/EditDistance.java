package DP;
//
//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//        You have the following three operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character

//If i is 0, dp[i][j] is equal to j, because the minimum edit distance between an empty string and a string of length j is j.
//
//        If j is 0, dp[i][j] is equal to i, because the minimum edit distance between a string of length i and an empty string is i.
//
//        If the characters at positions i-1 and j-1 of word1 and word2 respectively are equal, dp[i][j] is equal to dp[i-1][j-1], because no edit is needed.
//
//        If the characters at positions i-1 and j-1 of word1 and word2 respectively are not equal,
//        dp[i][j] is equal to 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]),
//        where dp[i-1][j-1] represents the minimum edit distance after replacing the character at position i-1 in word1 with the character at position j-1 in word2,
//        dp[i][j-1] represents the minimum edit distance after inserting the character at position j-1 of word2 into word1,
//        and dp[i-1][j] represents the minimum edit distance after deleting the character at position i-1 of word1.

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
