package BinaryTree;

public class ConstructBTPreOrderAndInOrder {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int rIndex = findIndex(preorder[index], inorder);
        index ++;
        root.left = helper(preorder, inorder, start, rIndex - 1);
        root.right = helper(preorder, inorder, rIndex + 1, end);
        return root;
    }

    private int findIndex(int value, int[] inorder){
        for (int i=0; i < inorder.length; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
}
