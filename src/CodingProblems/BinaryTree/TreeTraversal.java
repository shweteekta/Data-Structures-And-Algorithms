package BinaryTree;

public class TreeTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            super();
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode() {

        }
    }

    static void inOrderTraversal(TreeNode root){
        if (root != null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }
    static void preOrderTraversal(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }
    static void postOrderTraversal(TreeNode root){
        if (root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(10);
        root.right = new TreeNode(11);
        inOrderTraversal(root);
        preOrderTraversal(root);
        postOrderTraversal(root);
    }
}
