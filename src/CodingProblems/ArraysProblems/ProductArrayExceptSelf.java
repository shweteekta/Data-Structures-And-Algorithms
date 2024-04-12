package ArraysProblems;

import java.util.Arrays;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//        You must write an algorithm that runs in O(n) time and without using the division operation.
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
public class ProductArrayExceptSelf {
    // Doesn't work if array value is 0 so we will go with array lrft and right prod way
//    public static int[] productExceptSelf(int[] nums) {
//        var totalProd = Arrays.stream(nums).reduce((x, y) -> x*y).getAsInt();
//        for (int i=0; i<nums.length; i++) {
//            var quotient = doDivision(nums[i], totalProd);
//            nums[i] = quotient;
//        }
//        return nums;
//    }
//
//    private static int doDivision(int num, int totalProd) {
//        int count = 0;
//        while(totalProd != 0){
//            totalProd = totalProd - num;
//            count ++;
//        }
//        return count;
//    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        int leftProduct = 1; int rightProduct = 1;
        // Left Product
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * leftProduct;
            leftProduct *= nums[i];
        }
        // Right Product
        for (int i = nums.length-1; i >= 0 ; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }


    public static  void main(String[] args){
        int[] nums = {1,2,3,4};
        Arrays.stream(productExceptSelf(nums)).forEach(System.out::println);
    }
}
