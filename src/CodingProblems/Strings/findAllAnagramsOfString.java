package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//        Input: s = "cbaebabacd", p = "abc"
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
public class findAllAnagramsOfString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer>  smap = new HashMap<>();
        Map<Character,Integer>  pmap = new HashMap<>();
        for (Character ch:p.toCharArray()
             ) {
            if(pmap.containsKey(ch)){
                pmap.put(ch, pmap.get(ch) + 1);
            }
            else{
                pmap.put(ch,1);
            }
        }
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            smap.put(currentChar, smap.getOrDefault(currentChar, 0) + 1);
            if (i >= windowSize - 1) {
                if (smap.equals(pmap)) {
                    result.add(i - windowSize + 1);
                }
                char leftChar = s.charAt(i - windowSize + 1);
                if (smap.containsKey(leftChar)) {
                    smap.put(leftChar, smap.get(leftChar) - 1);
                    if (smap.get(leftChar) == 0) {
                        smap.remove(leftChar);
                    }
                }

            }
        }
            return result;
    }
    public static  void main(String[] args){
        String s = "abab" ; String p = "ab";
        System.out.println(findAnagrams(s,p));
    }
}
