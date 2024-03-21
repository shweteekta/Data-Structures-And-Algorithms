package BinaryTree;



public class BinaryTreeDiameter {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the diameter at each node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the subtree rooted at the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of BinaryTreeDiameter
        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();

        // Calculate and print the diameter of the binary tree
        int diameter = binaryTreeDiameter.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}
