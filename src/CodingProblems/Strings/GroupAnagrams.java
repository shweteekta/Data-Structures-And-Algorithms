package Strings;

import java.util.*;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray); // Convert char[] to String
            List<String> value = new ArrayList<>(map.getOrDefault(key, Collections.emptyList()));
            value.add(str);
            map.put(key, value);
            }
        for (String s:map.keySet()
             ) {
            group.add(map.get(s));
        }
        System.out.println(map);
        return group;
    }
    public static void main(String args[]) throws Exception {
     String[] str = {"eat","tea","tan","ate","nat","bat"};
     groupAnagrams(str).stream().forEach((i) -> System.out.println(i.toString()));
    }
}
