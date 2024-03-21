package BinaryTree;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}

// FOR BST
//public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//    if(p.val < root.val && q.val < root.val){
//        return lowestCommonAncestor(root.left,p,q);}
//    else if(p.val > root.val && q.val > root.val){
//        return lowestCommonAncestor(root.right,p,q);}
//    else{
//        return root;}
//}