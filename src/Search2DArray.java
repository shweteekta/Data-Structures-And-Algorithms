
public class Search2DArray {

    public static void main(String args[]) {
        int[][] mat = {{2, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.print(findTargetInMatrix(mat, 3));
    }

    static boolean findTargetInMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }

}


