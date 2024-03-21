package Strings;

import java.util.*;

//Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
public class LongestSubstringWithoutRepeatedChars {
    //Using DP
//    public static int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        int start = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length() ; i++) {
//            if(map.containsKey(s.charAt(i))){
//                start = Integer.max(start, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            maxLength = Integer.max(maxLength, i - start + 1);
//        }
//        return maxLength;
//    }
    public static int lengthOfLongestSubstring(String s) {
        // Using 2 pointers
        int maxLength = 0;
        int right = 0; int left = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
          if(set.contains(s.charAt(right))){
              set.remove(s.charAt(left));
              left++;
          }
          else{
              set.add(s.charAt(right));
              maxLength = Integer.max(maxLength, right - left + 1);
              right++;
          }
        }
        return maxLength;
    }

    public static  void main(String[] args){
        String  s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
