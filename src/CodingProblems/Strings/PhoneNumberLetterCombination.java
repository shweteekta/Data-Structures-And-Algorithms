package Strings;

import java.util.*;

public class PhoneNumberLetterCombination {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi",
                '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        getLetterCombinations(digits, map, result, new StringBuilder(), 0);
        return result;
    }

    private static void getLetterCombinations(String digits, Map<Character, String> map, List<String> result, StringBuilder str, int i) {
        if(i == digits.length()){
            result.add(str.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (char ch:letters.toCharArray()
             ) {
            str.append(ch);
            getLetterCombinations(digits,map,result,str,i+1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static  void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
