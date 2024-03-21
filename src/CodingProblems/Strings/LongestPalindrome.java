package Strings;

import java.util.HashMap;
import java.util.Map;

//Input: s = "abccccdd"
//        Output: 7
//        Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if(s.length() == 1){
            return 1;
        }
        int length = 0; boolean hasOddFlag =false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int frequency :map.values()){
            length += frequency/2 * 2;
            if(frequency % 2 != 0){
                hasOddFlag = true;
            }
        }
        return hasOddFlag ? length + 1 : length;
    }


    public static  void main(String[] args){
        String  s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
