package BinaryTree;

public class isSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootPreorder = new StringBuilder();
        StringBuilder subRootPreorder = new StringBuilder();

        // Get preorder traversal strings for both trees
        preorderTraversal(root, rootPreorder);
        preorderTraversal(subRoot, subRootPreorder);

        // Check if subRootPreorder is a substring of rootPreorder
        return rootPreorder.toString().contains(subRootPreorder);
    }

    private void preorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        preorderTraversal(node.left, sb);
        preorderTraversal(node.right, sb);
    }
}
