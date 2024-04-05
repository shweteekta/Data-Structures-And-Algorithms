package GraphBacktracking;

import java.util.*;

public class CourseScheduleII {
    //There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
//
//    Input: numCourses = 2, prerequisites = [[1,0]]
//    Output: [0,1]
//    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Construct the graph and calculate indegrees
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.putIfAbsent(prereq, new ArrayList<>());
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue to hold courses with zero indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        // BFS traversal
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            if (graph.containsKey(course)) {
                for (int neighbor : graph.get(course)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Check if all courses are taken
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
