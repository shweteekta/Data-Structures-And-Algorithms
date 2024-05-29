package BinaryTree;

import java.util.*;

public class PathSUMIII {
    static int counter = 0;

 // DFS Brute force approach
//    public static int pathSum(TreeNode root, int sum) {
//
//        if (root == null) return 0;
//
//        pathSumHelper(root, sum, 0);
//        pathSum(root.left, sum);
//        pathSum(root.right, sum);
//        return counter;
//
//    }
//
//    static void pathSumHelper(TreeNode root, int sum, long currentSum) {
//        if (root == null) {
//            return;
//        }
//        currentSum += root.val;
//        if (currentSum == sum) {
//            counter++;
//        }
//        pathSumHelper(root.left, sum, currentSum);
//        pathSumHelper(root.right, sum, currentSum);
//    }

    //Optimised way using HashMap
    static Map<Long, Integer> map = new HashMap<>();
    public static int pathSum(TreeNode root, int sum) {
        map.put(0L,1);
        pathSumHelper(root, sum, 0);
        return counter;

    }

    static void pathSumHelper(TreeNode root, int targetSum, long currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (map.containsKey(currentSum - targetSum)) {
            counter+= map.get(currentSum - targetSum);
        }
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        pathSumHelper(root.left, targetSum, currentSum);
        pathSumHelper(root.right, targetSum, currentSum);
        if(map.get(currentSum) == 1){
            map.remove(currentSum);
        }
        else {
            map.put(currentSum,map.get(currentSum) - 1);
        }
        currentSum -= root.val;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(-3);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        node.right.right = new TreeNode(11);
        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(-2);
        node.left.right.right = new TreeNode(1);
        System.out.println(pathSum(node, 8));

    }

}
