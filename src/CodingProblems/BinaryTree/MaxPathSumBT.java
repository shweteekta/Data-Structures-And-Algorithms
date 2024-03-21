package BinaryTree;
//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//        The path sum of a path is the sum of the node's values in the path.
//        Given the root of a binary tree, return the maximum path sum of any non-empty path.
//        Input: root = [1,2,3]
//        Output: 6
//        Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
public class MaxPathSumBT {
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    public static int maxPathSumHelper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);
        int currentMax = root.val + left + right;
        max = Math.max(max, currentMax);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left =new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

}
