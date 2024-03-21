public class CheckKnightTourCOnfiguration {
    private static final int[][] moves = {{2, 1}, {1, 2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2},
            {2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        return solveTourHelper(grid, 0, 0, 0, n);
    }

    private boolean solveTourHelper(int[][] grid, int steps, int row, int col, int n) {
        if (row < 0 || row >= n || col < 0 || col >= n || steps != grid[row][col]) {
            return false;
        }
        if (steps == n * n - 1) {
            return true;
        }

        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];

            if (solveTourHelper(grid, steps + 1, nextRow, nextCol, n)) {
                return true;
            }
        }

        return false;
    }

}
