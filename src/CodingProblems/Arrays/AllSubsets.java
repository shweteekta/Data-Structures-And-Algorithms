package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllSubsets {

    public static List<List<Integer>> generateSubsetsforNums(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsforNums(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generateSubsetsforNums(int[] nums, int index, List<Integer> current, List<List<Integer>> result ){
        if (index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        // Excluding that Element
        generateSubsetsforNums(nums, index+1, current, result);
        // Including that Element
        current.add(nums[index]);
        generateSubsetsforNums(nums,index + 1, current, result);
        System.out.println(current + " "+ current.get(current.size() - 1));
        current.remove(current.size() - 1);
    }

    public static List<String> generateSubsetsforString(String words){
        List<String> result = new ArrayList<>();
        generateSubsetsforString(words, 0, new StringBuilder(), result);
        return result;
    }

    private static void generateSubsetsforString(String words, int i, StringBuilder currentString, List<String> result) {
        if (i == words.length()){
            result.add(currentString.toString());
            return;
        }
        // Excluding that character
        generateSubsetsforString(words, i + 1, currentString, result);
        currentString.append(words.charAt(i));
        generateSubsetsforString(words, i + 1, currentString, result);
        currentString.deleteCharAt(currentString.length() - 1);
    }


    public static void main(String[] args){
        int[] numbers = {1,2,3};
        String words = "abc";
        generateSubsetsforNums(numbers).stream().forEach(System.out::println);
        generateSubsetsforString(words).stream().forEach(System.out::println);
    }
}
