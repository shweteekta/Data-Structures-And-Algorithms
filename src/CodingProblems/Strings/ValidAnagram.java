package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            setMapValue(s, smap, i);
            setMapValue(t,tmap,i);
        }
        if (smap.equals(tmap)){
            return true;
        }
        return false;
    }

    private static void setMapValue(String s, Map<Character, Integer> smap, int i) {
        if(smap.containsKey(s.charAt(i))){
            smap.put(s.charAt(i), smap.get(s.charAt(i))+1);
        }
        else{
            smap.put(s.charAt(i), 1);
        }
    }

    public static  void main(String[] args){
        String s = "anagram1";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
