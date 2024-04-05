package GraphBacktracking;

public class KnightsTour {
    private static final int N = 8; // The size of the chessboard
    private static final int[][] moves = {{2, 1}, {1, 2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}};

    private int[][] chessboard;

    public KnightsTour() {
        this.chessboard = new int[N][N];
    }

    private void solveTour() {
        if(solveTourHelper(1, 0, 0)){
            printSolution();
        }
        else {
            System.out.println("Solution doesn't exists");
        }
    }

    private boolean solveTourHelper(int stepCount, int xMoves, int yMoves) {
        if (stepCount == N * N ) {
            return true;
        }

        for (int moveIndex = 0; moveIndex < moves.length; moveIndex++) {
            int nextX = xMoves + moves[moveIndex][0];
            int nextY = yMoves + moves[moveIndex][1];

            if (isValidMove(nextX, nextY)) {
                chessboard[nextX][nextY] = stepCount;
                if (solveTourHelper(stepCount + 1, nextX, nextY)) {
                    return true;
                }
                chessboard[nextX][nextY] = 0; // Backtrack if the move doesn't lead to a solution
            }
        }

        return false;
    }


    private boolean isValidMove(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && chessboard[x][y] == 0);
    }


    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", chessboard[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightsTour knightsTour = new KnightsTour();
        knightsTour.solveTour();
    }

}
