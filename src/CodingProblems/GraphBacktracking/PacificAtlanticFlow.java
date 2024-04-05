package GraphBacktracking;

import java.util.*;

public class PacificAtlanticFlow {
    //    There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//    The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//    The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//    Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, 0, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;

    }

    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;
        int[][] positions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] pos: positions){
            int newRow = row + pos[0];
            int newCol = row + pos[1];
            if (newRow >= 0 && newCol >=0 && newRow < heights.length && newCol < heights[0].length && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]){
                dfs(heights, ocean, newRow, newCol);
            }
        }
    }
}
