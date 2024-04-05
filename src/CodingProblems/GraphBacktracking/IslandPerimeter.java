package GraphBacktracking;

import java.util.*;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {

        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] moves = {{-1,0}, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    grid[i][j] = 2;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            cnt = cnt + 4;

            for (int[] dir : moves) {
                int newRow = pos[0] + dir[0];
                int newCol = pos[1] + dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {

                    if (grid[newRow][newCol] == 2){
                        cnt = cnt - 1;
                    }
                    if (grid[newRow][newCol] == 1) {
                        cnt = cnt - 1;
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] { newRow, newCol });
                    }

                }
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        int[][] grid = {{1,1},{1,1}};
        System.out.println(islandPerimeter(grid));
    }
}
