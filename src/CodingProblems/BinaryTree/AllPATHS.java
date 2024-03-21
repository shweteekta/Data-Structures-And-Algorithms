package BinaryTree;

import java.util.*;

public class AllPATHS {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, result, "");
        return result;
    }
    public void binaryTreePaths(TreeNode root, List<String> result, String str) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            result.add(str + root.val);
            return;
        }
        else{
            binaryTreePaths(root.left,result,str + root.val + "->");
            binaryTreePaths(root.right,result,str + root.val + "->");
        }
    }
}
