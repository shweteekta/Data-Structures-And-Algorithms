package Matrix;

import java.util.*;

public class ZeroOneMatrixProblem {

//    To solve this problem, we can use a breadth-first search (BFS) approach. The idea is to start from each cell containing 0 and traverse the matrix to find the nearest 0 for each cell containing 1.
//    Here's the step-by-step explanation of the solution:
//    Initialization: Initialize a queue to perform BFS. Enqueue all cells containing 0 into the queue.
//    BFS Traversal: While th  e queue is not empty, dequeue a cell and explore its neighbors. For each neighbor cell:
//    If the neighbor cell is within the matrix bounds and its value is not yet updated (indicating it hasn't been visited), update its value to be the minimum of its current value and the distance to the current cell plus 1. Enqueue the neighbor cell into the queue.
//    Final Result: After BFS traversal, the values in the matrix will represent the distance of each cell to the nearest 0.
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int[][] moves = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] move : moves) {
                int x = pos[0] + move[0];
                int y = pos[1] + move[1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    mat[x][y] = mat[pos[0]][pos[1]] + 1; // Update the distance
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
        }
        return mat;
    }
}
