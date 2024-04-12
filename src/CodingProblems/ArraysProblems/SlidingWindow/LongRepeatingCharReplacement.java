package ArraysProblems.SlidingWindow;

import java.util.*;

public class LongRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, map.get(currentChar));
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(characterReplacement("AABABBA",1));
    }
}
