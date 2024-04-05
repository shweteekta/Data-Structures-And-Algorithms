package GraphBacktracking;

public class SudokuSolver {
    private static final int BOARD_SIZE = 9;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public void solveProblem() {
        if (solve(0, 0)) {
            printSolution();
        } else {
            System.out.println("No solution exists");
        }
    }

    private boolean solve(int rowIndex, int colIndex) {
        if (rowIndex == BOARD_SIZE) {
            rowIndex = 0;
            colIndex++;
            if (colIndex == BOARD_SIZE) return true;
        }
        //skip filled cells
        if(board[rowIndex][colIndex] != 0){
            return solve(rowIndex+1, colIndex);
        }
        for (int num = MIN_NUMBER; num <= MAX_NUMBER; num++) {
            if(isValid(rowIndex,colIndex,num)){
                   board[rowIndex][colIndex] = num;
                if (solve(rowIndex+1, colIndex)){
                    return true;
                }
                board[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num) {
        for(int i=0;i<BOARD_SIZE;i++){
            if(board[rowIndex][i] == num) return false;
        }
        for(int i=0;i<BOARD_SIZE;i++){
            if(board[i][colIndex] == num) return false;
        }
        int boxRowOffset = (rowIndex / 3)* 3;
        int boxColOffset = (colIndex / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[boxRowOffset + i][boxColOffset + i] == num) {
                return  false;}
            }
        }
        return true;
    }

    private void printSolution() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (row % 3 == 0) System.out.println();
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (col % 3 == 0) System.out.print(" ");
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        SudokuSolver solver = new SudokuSolver(board);
        solver.solveProblem();
    }

}
