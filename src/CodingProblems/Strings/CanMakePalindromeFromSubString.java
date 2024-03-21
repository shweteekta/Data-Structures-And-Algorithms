package Strings;

import java.util.*;

public class CanMakePalindromeFromSubString {
    public class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            List<Boolean> result = new ArrayList<>();

            // Preprocess the input string
            int[][] charCounts = preprocess(s);

            for (int[] query : queries) {
                result.add(checkPalindrome(charCounts, query));
            }

            return result;
        }

        private int[][] preprocess(String s) {
            int n = s.length();
            int[][] charCounts = new int[n + 1][26]; // Array to store count of characters up to each index

            for (int i = 0; i < n; i++) {
                charCounts[i + 1] = charCounts[i].clone(); // Copy previous count
                charCounts[i + 1][s.charAt(i) - 'a']++; // Increment count of current character
            }

            return charCounts;
        }

        private boolean checkPalindrome(int[][] charCounts, int[] query) {
            int oddCount = 0;
            int[] charCountStart = charCounts[query[0]];
            int[] charCountEnd = charCounts[query[1] + 1];

            // Calculate count of each character within the specified range
            for (int i = 0; i < 26; i++) {
                int count = charCountEnd[i] - charCountStart[i];
                if (count % 2 != 0) {
                    oddCount++;
                }
            }

            // Check if the number of odd occurrences is less than or equal to k
            return oddCount / 2 <= query[2];
        }
    }

}
