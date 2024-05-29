package GraphBacktracking;

import java.util.*;

public class MinTimeVisitDisappearNode {
//    Input:  n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
//    Output:  [0,-1,4]
//    Explanation:
//    We are starting our journey from node 0, and our goal is to find the minimum time required to reach each node before it disappears.
//    For node 0, we don't need any time as it is our starting point.
//    For node 1, we need at least 2 units of time to traverse edges[0]. Unfortunately, it disappears at that moment, so we won't be able to visit it.
//    For node 2, we need at least 4 units of time to traverse edges[2].
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (answer[node] != -1) continue;

            answer[node] = time;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextTime = time + next[1];
                if (nextTime < disappear[nextNode]) {
                    pq.offer(new int[]{nextNode, nextTime});
                }
            }
        }

        return answer;

    }
}
