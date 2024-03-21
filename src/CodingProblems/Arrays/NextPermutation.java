package Arrays;
//Input
//        nums =
//        [1,3,2]
//        Stdout
//        2 0
//        Output
//        [2,1,3]
public class NextPermutation  {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int index = nums.length - 1;
        while(index > 0){
            if(nums[index] > nums[index-1]){
                pivot = index -1;
                break;
            }
            index--;
        }
        if(pivot != -1){
            int j = nums.length - 1;

            while (j > pivot && nums[j] <= nums[pivot]) {
                j--;
            }

            System.out.println(j + " " + pivot);
            int temp = nums[pivot];
            nums[pivot] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, pivot + 1);
    }

    public void reverse(int[] nums, int low){
        int high = nums.length - 1;
        while (low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low ++ ;
            high --;
        }
    }


}

