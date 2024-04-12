package ArraysProblems;
//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

import java.util.Arrays;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        var check = Arrays.stream(nums).reduce((x,y) -> (x^y)).getAsInt();
        System.out.println(check);
        return Arrays.stream(nums).distinct().count() == nums.length;
    }
    public static  void main(String[] args) {
        int[] nums = {2,3,6,2};
        System.out.println("CheckDuplicate  " + !containsDuplicate(nums));
    }
}
