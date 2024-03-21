package BinaryTree;

public class MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int index = calcMaxIndex(nums,start,end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index - 1);
        root.right = helper( nums,index + 1, end);
        return root;
    }



    public int calcMaxIndex(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE; int index = 0;
        for(int i= start; i <=end; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
