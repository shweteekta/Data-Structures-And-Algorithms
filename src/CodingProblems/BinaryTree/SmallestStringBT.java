package BinaryTree;

public class SmallestStringBT {

    static String result = "zzzzzzzzz";
    public static String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return result;
    }

    private static void dfs(TreeNode root, StringBuilder str){
        if(root == null){
            if(str.toString().compareTo(result) < 0){
                result = str.toString();
            }
            return;
        }
        dfs(root.left,str);
        str.append(root.val);
        dfs(root.right,str);
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(4);
        dfs(node,new StringBuilder());
    }

}
