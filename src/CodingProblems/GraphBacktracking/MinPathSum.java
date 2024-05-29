package GraphBacktracking;

public class MinPathSum {
    static int min = Integer.MAX_VALUE;
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dfs(grid, m, n, 0, 0, 0);
        return min;
    }

    private static void dfs(int[][] grid, int m, int n, int i,int j, int sum){
        if (i >= m || j >= n || i < 0 || j < 0){
            return ;
        }
        if (i == m-1 && j == n-1){
            min = Math.min(min, grid[i][j] + sum);
            return;
        }
        dfs(grid, m, n, i+1, j, sum + grid[i][j]);
        dfs(grid, m, n, i, j+1, sum + grid[i][j]);

        return;
    }

    public static void main(String[] args){
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }


}
