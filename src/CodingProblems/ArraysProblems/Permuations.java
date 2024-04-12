package ArraysProblems;

import java.util.*;

public class Permuations {
    public static  void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(getPermutations(nums));
    }

    private static List<List<Integer>> getPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutations(nums, result, new ArrayList<>());
        return result;
    }

    private static void getPermutations(int[] nums, List<List<Integer>> result, List<Integer> collect) {
        if(collect.size() == nums.length){
            result.add(new ArrayList<>(collect));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(result.size() == 3){
                break;
            }
            if(!collect.contains(nums[i])){
                collect.add(nums[i]);
                getPermutations(nums, result, collect);
                collect.remove(collect.size() - 1);
            }
        }
    }
}
