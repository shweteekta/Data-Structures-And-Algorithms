import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 0, 0, 0)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 0)));
        maze.add(new ArrayList<>(List.of(0, 1, 1,1 )));

        int n = maze.size();
        List<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();
        boolean[][] visited = new boolean[n][n];
        findPath(0, 0, maze, n, result, currentPath, visited);

        if (result.isEmpty())
            System.out.println(-1);
        else
            result.forEach(path -> System.out.print(path + " "));
        System.out.println();
    }

    private static void findPath(int row, int col, List<List<Integer>> maze, int n, List<String> result, StringBuilder currentPath, boolean[][] visited) {
        if (row == n - 1 && col == n - 1) {
            result.add(currentPath.toString());
            return;
        }
        if (row < 0 || col < 0 || row > n - 1 || col > n - 1 || visited[row][col] || maze.get(row).get(col) != 1) {
            return;
        }
        visited[row][col] = true;

        // Move Up
        findPath(row - 1, col, maze, n, result, currentPath.append("U"), visited);
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        // Move Down
        findPath(row + 1, col, maze, n, result, currentPath.append("D"), visited);
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        // Move Right
        findPath(row, col + 1, maze, n, result, currentPath.append("R"), visited);
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        // Move Left
        findPath(row, col - 1, maze, n, result, currentPath.append("L"), visited);
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        visited[row][col] = false; // Unmark the cell for backtracking
    }
}
