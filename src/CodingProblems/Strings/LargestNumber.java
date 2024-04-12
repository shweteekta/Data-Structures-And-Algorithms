package Strings;

public class LargestNumber {
//    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
//    Since the result may be very large, so you need to return a string instead of an integer.
//    Input: nums = [10,2]
//    Output: "210"
//    Example 2:
//
//    Input: nums = [3,30,34,5,9]
//    Output: "9534330"
public String largestNumber(int[] nums) {
    String[] snums = new String[nums.length];

    // Convert nums to String array
    for (int i = 0; i < nums.length; i++) {
        snums[i] = Integer.toString(nums[i]);
    }

    // Custom sorting logic without Comparator
    for (int i = 0; i < snums.length - 1; i++) {
        for (int j = i + 1; j < snums.length; j++) {
            String order1 = snums[i] + snums[j];
            String order2 = snums[j] + snums[i];
            // Compare based on concatenated strings
            if (order2.compareTo(order1) > 0) {
                // Swap snums[i] and snums[j]
                String temp = snums[i];
                snums[i] = snums[j];
                snums[j] = temp;
            }
        }
    }

//    // Comparator to decide which string should come first in concatenation
//    Comparator<String> comp = new Comparator<String>(){
//        @Override
//        public int compare(String str1, String str2){
//            String s1 = str1 + str2;
//            String s2 = str2 + str1;
//            return s2.compareTo(s1); // reverse order here, so we can do append() later
//        }
//    };
//
//    Arrays.sort(s_num, comp);

    // Handle case where all elements are zero
    if (snums[0].equals("0")) return "0";

    // Concatenate sorted strings to form the result
    StringBuilder result = new StringBuilder();
    for (String s : snums) {
        result.append(s);
    }

    return result.toString();
}
}
