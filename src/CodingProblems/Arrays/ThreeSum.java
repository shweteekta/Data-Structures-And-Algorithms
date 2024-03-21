package Arrays;

import java.util.*;
import java.util.stream.Collectors;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        getThreeSets(nums,0, new ArrayList<>(),resultSet);
        return new ArrayList<>(resultSet);
    }

    private static void getThreeSets(int[] nums, int i,List<Integer> sets, Set<List<Integer>> resultSet) {
        if(i == nums.length || sets.size() == 3){
            if (sets.size() == 3 && sets.get(0) + sets.get(1) + sets.get(2) == 0){
                resultSet.add(new ArrayList<>(sets.stream().sorted().collect(Collectors.toList())));
            }
            return;
        }
        getThreeSets(nums, i+1, sets, resultSet);
        sets.add(nums[i]);
        getThreeSets(nums, i+1, sets, resultSet);
        sets.remove(sets.size() - 1);
    }

    public static  void main(String[] args){
        int[] nums = {1,-1,-1,0};
        System.out.println("Three Sum -" + threeSum(nums) );
    }
}
//Four SUM Solution
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Set<List<Integer>> result = new HashSet<>();;
//        //getFourSum(nums, target, 0, result, new ArrayList<>());
//        Arrays.sort(nums);
//        for(int i =0; i < nums.length - 3; i++){
//            for(int j = i+1; j < nums.length - 2; j++){
//                long curr_sum = (long) nums[i] + nums[j];
//                int low = j + 1;
//                int high = nums.length - 1;
//                while(low < high){
//                    if(curr_sum + nums[high] + nums[low] > target){
//                        high --;
//                    }
//                    else if (curr_sum + nums[high] + nums[low] < target){
//                        low ++;
//                    }
//                    else{
//                        result.add(List.of(nums[i],nums[j],nums[low],nums[high]));
//                        low++;
//                        high--;
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }
