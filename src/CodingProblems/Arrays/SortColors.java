package Arrays;

import java.util.Arrays;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//        You must solve this problem without using the library's sort function.
//        Input: nums = [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
public class SortColors {
    public static void sortColors(int[] nums) {
//        int cntRed = 0;
//        int cntWhite = 0;
//        int cntBlue = 0;
//        for (int num:
//             nums) {
//            if (num == 0){
//                cntRed++;
//            }
//            else if(num == 1){
//                cntWhite++;
//            }
//            else{
//                cntBlue++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = cntRed !=0 ? 0 : cntWhite != 0 ? 1 : 2;
//            if(cntRed != 0){
//                cntRed--;
//            }
//            else if (cntRed == 0 && cntWhite != 0){
//                cntWhite--;
//            }
//            else{
//                cntBlue--;
//            }
//        }

        int low = 0;
        int current = 0;
        int high = nums.length - 1;
        while (current <= high){
            if (nums[current] == 0){
               swap(nums, current, low);
               current++;
               low++;
            }
            else if(nums[current] == 1){
                current++;
            }
            else{
                swap(nums, current, high);
                high --;
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
