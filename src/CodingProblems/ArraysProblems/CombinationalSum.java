package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
//        Explanation:
//        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//        7 is a candidate, and 7 = 7.
//        These are the only two combinations.
public class CombinationalSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationSum(candidates, 0,target, new ArrayList<>(), result);
        return result;
    }

    private static void getCombinationSum(int[] candidates, int i,int target, ArrayList<Integer> collect, List<List<Integer>> result) {
        if ( i == candidates.length){
            if ( target == 0){
                result.add(new ArrayList<>(collect));
            }
            return;
        }

        //Pick
        if(candidates[i] <= target){
            collect.add(candidates[i]);
            getCombinationSum(candidates, i, target - candidates[i], collect, result);
            collect.remove(collect.size() - 1);
        }
        getCombinationSum(candidates, i+1, target, collect, result);
    }

    public static  void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println("CombinationalSUm " + combinationSum(nums, target));
    }
}
