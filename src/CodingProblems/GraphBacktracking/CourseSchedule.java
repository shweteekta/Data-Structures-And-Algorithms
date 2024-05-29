package GraphBacktracking;

import java.util.*;

public class CourseSchedule {
//    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//    Return true if you can finish all courses. Otherwise, return false.
//    Example 1:
//    Input: numCourses = 2, prerequisites = [[1,0]]
//    Output: true
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0. So it is possible.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> list = new HashMap<>();
        for (int[] edges : prerequisites) {
            list.put(edges[0], list.getOrDefault(edges[0], new ArrayList<>()));
            list.get(edges[0]).add(edges[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] neighborVisit = new boolean[numCourses];
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
