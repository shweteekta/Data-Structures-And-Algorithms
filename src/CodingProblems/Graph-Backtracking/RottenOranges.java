import java.util.*;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int numOfOranges = 0;
        int mins = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    numOfOranges++;
                }
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col, 0});
                }
            }
        }
        if (numOfOranges == 0) return 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            mins = pos[2];
            for (int[] move : directions) {
                int newX = row + move[0];
                int newY = col + move[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                    numOfOranges--;
                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY, mins + 1});
                }
            }
        }
        return numOfOranges == 0 ? mins : -1;

    }


    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
