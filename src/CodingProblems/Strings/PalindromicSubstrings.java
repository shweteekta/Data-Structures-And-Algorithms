package Strings;

public class PalindromicSubstrings {
    //    Given a string s, return the number of palindromic substrings in it.
//
//    A string is a palindrome when it reads the same backward as forward.
//
//    A substring is a contiguous sequence of characters within the string.
//    Input: s = "abc"
//    Output: 3
//    Explanation: Three palindromic strings: "a", "b", "c".
//    Example 2:
//
//    Input: s = "aaa"
//    Output: 6
//    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countPalindrome(s, i, i);
            countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void countPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            count++;
            low--;
            high++;
        }
    }
}
