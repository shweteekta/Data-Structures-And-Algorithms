package Strings;
//Given a string s, return the longest
//        palindromic  substring
//        in s.
//        Example 1:
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
public class LongestPalindromicSubstring {
    static int maxLength = 0 ; static int start = 0;
    public static String longestPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1){
            return s;
        }
        for (int i = 0; i <s.length() ; i++) {
            getPalidromeStartAndEndIndex(s,i,i);
            getPalidromeStartAndEndIndex(s,i,i+1);
        }
        return s.substring(start, start + maxLength );
    }

    private static void getPalidromeStartAndEndIndex(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (maxLength < right - left - 1){
            maxLength = right - left - 1;
            start = left + 1;
        }
    }

    public static  void main(String[] args){
        String  s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
