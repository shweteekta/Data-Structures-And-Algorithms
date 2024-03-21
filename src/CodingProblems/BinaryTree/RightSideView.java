package BinaryTree;

import java.util.*;

//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//        Input: root = [1,2,3,null,5,null,4]
//        Output: [1,3,4]
public class RightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        getRightSideView(root, 0, result);
        return result;
    }
    private static void getRightSideView(TreeNode root, int value, List<Integer> result) {
        if (root == null){
            return;
        }
        if (value == result.size()){
            result.add(root.val);
        }

        getRightSideView(root.right, value + 1, result);
        getRightSideView(root.left, value + 1, result);
    }
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);

        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }

    private void dfs(TreeNode node, int distance, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        map.put(distance, node.val);

        // Traverse left and right subtrees, adjusting horizontal distance
        dfs(node.left, distance - 1, map);
        dfs(node.right, distance + 1, map);
    }

    public static List<Integer> LeftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getLeftSideView(root, 0, result);
        return result;
    }
    private static void getLeftSideView(TreeNode root, int value, List<Integer> result) {
        if (root == null){
            return;
        }
        if (value == result.size()){
            result.add(root.val);
        }
        getLeftSideView(root.left, value + 1, result);
        getLeftSideView(root.right, value + 1, result);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        root.left.right.right = new TreeNode(8);
        System.out.println(rightSideView(root));
        System.out.println(LeftSideView(root));
    }
}
