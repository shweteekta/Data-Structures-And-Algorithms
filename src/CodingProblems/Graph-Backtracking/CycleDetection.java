import java.util.*;

public class CycleDetection {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Detect Cycles
        // 1. Build the Adjacency List Representation
        Map<Integer, List<Integer>> list = new HashMap<>();
        for (int[] edges : prerequisites) {
            list.put(edges[0], list.getOrDefault(edges[0], new ArrayList<>()));
            list.get(edges[0]).add(edges[1]);
        }
        // 2. Boolean Array to keep track of visited Edges
        boolean[] visited = new boolean[numCourses];
        boolean[] neighborVisit = new boolean[numCourses];
        // 3. Perform a DFS or BFS traversal starting from each course. During the
        // traversal, mark each visited course and check if there is a cycle in the
        // graph.
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, list, visited, neighborVisit))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int vertex, Map<Integer, List<Integer>> list, boolean[] visited, boolean[] neighborVisit) {
        visited[vertex] = true;
        neighborVisit[vertex] = true;
        if (list.containsKey(vertex)) {
            for (Integer neigborNode : list.get(vertex)) {
                if (!visited[neigborNode]) {
                    if (dfs(neigborNode, list, visited, neighborVisit)) {
                        return true;
                    }
                } else if (neighborVisit[neigborNode]) {
                    return true;
                }
            }
        }
        neighborVisit[vertex] = false;
        return false;

    }
}
