package GraphBacktracking;

import java.util.*;

public class DetonateMaxBombs {
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int n = bombs.length;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++)
                map.put(i, new ArrayList<>());
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double dx = bombs[i][0] - bombs[j][0];
                    double dy = bombs[i][1] - bombs[j][1];
                    double r1 = bombs[i][2], r2 = bombs[j][2];
                    double dist = dx * dx + dy * dy;
                    if (dist <= r1 * r1)
                        map.get(i).add(j);
                    if (dist <= r2 * r2)
                        map.get(j).add(i);
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Integer.max(max, dfs(map, i, new boolean[n]));
                if(max == n) return max;
            }
            return max;
        }

        private int dfs(Map<Integer, List<Integer>> map, int startBomb, boolean[] visited) {
            visited[startBomb] = true;
            int count = 1;
            for (int neighborBomb : map.get(startBomb)) {
                if (!visited[neighborBomb]) {
                    // Recursively explore the neighboring bombs
                    count += dfs(map, neighborBomb, visited);
                }
            }
            return count;
        }
    }
}
