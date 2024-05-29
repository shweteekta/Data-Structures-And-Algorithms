package BinaryTree;

import java.util.*;

public class MaxWidthBT {
//    The maximum width of a tree is the maximum width among all levels.
        public int widthOfBinaryTree(TreeNode root) {
            traverse(root, 1, 1);
            return maxWidth;
        }

        ArrayList<Integer> firstIds = new ArrayList<>();
        int maxWidth = 1;

        public void traverse(TreeNode root, int id, int depth) {
            if (root == null) return;

            if (firstIds.size() == depth - 1) {
                firstIds.add(id);
            } else {
                maxWidth = Math.max(maxWidth, id - firstIds.get(depth - 1) + 1);
            }

            traverse(root.left, 2 * id, depth + 1);
            traverse(root.right, 2 * id + 1, depth + 1);
        }
//    public int widthOfBinaryTree(TreeNode root) {
//        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        int maxWidth = 0;
//
//        queue.offer(new Pair<>(root, 0));
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            int startIndex = queue.peek().getValue();
//            int index = 0;
//            for (int i=0;i<size;i++){
//                Pair<TreeNode, Integer> pair = queue.poll();
//                TreeNode node = pair.getKey();
//                index = pair.getValue();
//                if(node.left != null){
//                    queue.offer(new Pair<>(node.left, 2*index));
//                }
//                if(node.right != null){
//                    queue.offer(new Pair<>(node.right, 2*index + 1));
//                }
//            }
//            maxWidth = Math.max(maxWidth, index - startIndex + 1);
//
//        }
//
//        return maxWidth;
//    }
}
