public class NQueensProblem {

    private int[][] chessTable;
    private int numOfQueens;

    public NQueensProblem(int numOfQueens){
        this.numOfQueens = numOfQueens;
        this.chessTable = new int[numOfQueens][numOfQueens];
    }

    public void solve(){
        if(setQueens(0)){
            printQueens();
        }
        else {
            System.out.println("There is no solution");
        }
    }

    private boolean setQueens(int rowIndex){
        if (rowIndex == numOfQueens)
            return true;
        for (int i = 0; i < numOfQueens; i++) {
            if(isPlaceValid(rowIndex, i)){
                chessTable[rowIndex][i] = 1;
                if (setQueens(rowIndex + 1)) {
                    return true;
                }
                // If placing the queen in the current position doesn't lead to a solution,
                // backtrack by resetting the current position to 0
                chessTable[rowIndex][i] = 0;
            }
        }
        return false;
    }

    private void printQueens(){
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j] == 1){
                    System.out.print("Q");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();

        }
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (chessTable[i][colIndex] == 1) {
                return false;
            }
        }
        // Left Diagonal
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessTable[i][j] == 1){
                return false;
            }
        }
        // right diagonal
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < numOfQueens; i--, j++){
            if(chessTable[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueensProblem nQueensProblem = new NQueensProblem(4);
        nQueensProblem.solve();
    }
}
