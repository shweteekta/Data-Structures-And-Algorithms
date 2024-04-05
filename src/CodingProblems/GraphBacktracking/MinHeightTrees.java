package GraphBacktracking;
import java.util.*;

public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Build adjacency list to represent the tree
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Initialize queue with leaf nodes
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        // Continue trimming the leaves until there are at most two nodes left
        while (n > 2) {
            int size = leaves.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }

        // The remaining nodes in the queue are the roots of the minimum height trees
        List<Integer> result = new ArrayList<>(leaves);
        return result;
    }
}
